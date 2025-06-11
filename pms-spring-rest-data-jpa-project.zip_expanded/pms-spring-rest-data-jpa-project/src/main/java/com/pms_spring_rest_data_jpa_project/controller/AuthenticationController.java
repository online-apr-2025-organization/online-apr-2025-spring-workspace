package com.pms_spring_rest_data_jpa_project.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms_spring_rest_data_jpa_project.dao.UserDao;
import com.pms_spring_rest_data_jpa_project.dao.entity.UserEntity;
import com.pms_spring_rest_data_jpa_project.pojo.UserTokenPojo;
import com.pms_spring_rest_data_jpa_project.service.JwtService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDao userDao;
	
	@PostMapping("/validate")
	public UserTokenPojo validate(@RequestBody UserEntity userInfo) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getUserName(), userInfo.getUserPassword()));
		if (authentication.isAuthenticated()) {
			Collection<? extends GrantedAuthority> allAuthorities = authentication.getAuthorities();
//			userInfo.setAllRoles(allAuthorities.stream().map((eachAuthority)-> { new RoleEntity().setRoleName(eachAuthority.getAuthority())).collect(Collectors.toList()));
			Optional<UserEntity> fetchUser = userDao.findByUserName(userInfo.getUserName());
			return new UserTokenPojo(jwtService.generateToken(userInfo.getUserName()), fetchUser.get());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

}
