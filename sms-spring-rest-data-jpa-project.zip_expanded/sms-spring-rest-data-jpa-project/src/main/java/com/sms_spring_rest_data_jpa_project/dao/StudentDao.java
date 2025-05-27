package com.sms_spring_rest_data_jpa_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms_spring_rest_data_jpa_project.entity.StudentEntity;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity, Integer> {

}
