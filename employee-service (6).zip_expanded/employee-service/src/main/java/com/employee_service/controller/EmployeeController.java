package com.employee_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.employee_service.dao.EmployeeDao;
import com.employee_service.dao.entity.EmployeeEntity;
import com.employee_service.pojo.DepartmentPojo;
import com.employee_service.pojo.EmployeePojo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeDao empDao;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
		return new ResponseEntity<List<EmployeeEntity>>(empDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{empId}")
	@CircuitBreaker(name="myCB", fallbackMethod = "fallBackEmployee")
	public ResponseEntity<EmployeePojo> getAEmployee(@PathVariable int empId){
		Optional<EmployeeEntity> fetchedEmpOpt = empDao.findById(empId);
		EmployeeEntity fetchedEmp = null;
		EmployeePojo empPojo = null;
		if(fetchedEmpOpt.isPresent()) {
			fetchedEmp = fetchedEmpOpt.get();
			RestClient restClient = RestClient.create();
			DepartmentPojo fetchedDept = restClient
											.get()
											.uri("http://localhost:8081/api/departments/"+fetchedEmp.getEmpDeptId())
											.retrieve()
											.body(DepartmentPojo.class);
			empPojo = new EmployeePojo();
			BeanUtils.copyProperties(fetchedEmp, empPojo);
			empPojo.setEmpDept(fetchedDept);
		}
		
		return new ResponseEntity<EmployeePojo>(empPojo, HttpStatus.OK);
	}
	
	public ResponseEntity<EmployeePojo> fallBackEmployee(){
		return new ResponseEntity<EmployeePojo>(new EmployeePojo(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
