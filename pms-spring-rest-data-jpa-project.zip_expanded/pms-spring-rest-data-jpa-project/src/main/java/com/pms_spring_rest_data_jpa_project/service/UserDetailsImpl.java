package com.pms_spring_rest_data_jpa_project.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pms_spring_rest_data_jpa_project.dao.entity.RoleEntity;

public class UserDetailsImpl implements UserDetails {

	private String userName;
	private String userPassword;
	private List<SimpleGrantedAuthority> allRoles;

	public UserDetailsImpl(String userName, String userPassword, List<RoleEntity> allRoles) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.allRoles = allRoles.stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).toList();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return allRoles;
	}

	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public String getUsername() {
		return userName;
	}
}
