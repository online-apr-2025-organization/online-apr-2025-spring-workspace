package com.pms_spring_rest_data_jpa_project.pojo;

import com.pms_spring_rest_data_jpa_project.dao.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserTokenPojo {
	private String token;
	private UserEntity user;
}
