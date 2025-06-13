package com.department_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.department_service.dao.entity.DepartmentEntity;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Integer>{

}
