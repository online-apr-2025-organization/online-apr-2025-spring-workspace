package com.pms_spring_rest_data_jpa_project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms_spring_rest_data_jpa_project.dao.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer>{
	List<ProductEntity> findByProductCategory(String pCategory);
}
