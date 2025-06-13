package com.department_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department_service.dao.DepartmentDao;
import com.department_service.dao.entity.DepartmentEntity;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentDao deptDao;
	
	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentEntity>> getAllDepartments(){
		return new ResponseEntity<List<DepartmentEntity>>(deptDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/departments/{did}")
	public ResponseEntity<Optional<DepartmentEntity>> getADepartments(@PathVariable("did") int deptId){
		return new ResponseEntity<Optional<DepartmentEntity>>(deptDao.findById(deptId), HttpStatus.OK);
	}
}
