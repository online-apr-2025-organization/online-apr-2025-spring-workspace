package com.pms_spring_rest_data_jpa_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms_spring_rest_data_jpa_project.dao.UserDao;
import com.pms_spring_rest_data_jpa_project.dao.entity.UserEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> fetchedUser = userDao.findByUserName(username);
		System.out.println(fetchedUser);
		// now we have to copy everything from UserEntity object to UserDetails implementation class object
		return fetchedUser
				.map((userData)->new UserDetailsImpl(userData.getUserName(), userData.getUserPassword(), userData.getAllRoles()))
				.orElseThrow(()-> new UsernameNotFoundException(username + " not found!!"));
	
	}

}
