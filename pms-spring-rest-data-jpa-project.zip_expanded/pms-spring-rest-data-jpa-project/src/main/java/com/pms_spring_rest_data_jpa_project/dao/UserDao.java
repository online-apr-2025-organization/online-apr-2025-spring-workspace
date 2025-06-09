package com.pms_spring_rest_data_jpa_project.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms_spring_rest_data_jpa_project.dao.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{
	Optional<UserEntity> findByUserName(String userName);
}
