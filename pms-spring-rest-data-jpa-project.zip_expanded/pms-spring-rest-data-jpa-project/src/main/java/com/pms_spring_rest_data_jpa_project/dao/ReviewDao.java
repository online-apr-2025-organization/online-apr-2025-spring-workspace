package com.pms_spring_rest_data_jpa_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms_spring_rest_data_jpa_project.dao.entity.ReviewEntity;

@Repository
public interface ReviewDao extends JpaRepository<ReviewEntity, Integer>{

}
