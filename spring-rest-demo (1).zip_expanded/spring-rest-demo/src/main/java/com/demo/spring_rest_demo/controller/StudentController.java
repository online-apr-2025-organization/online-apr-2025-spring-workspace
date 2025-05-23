package com.demo.spring_rest_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_rest_demo.pojo.StudentPojo;

@RestController
@RequestMapping("/api")
public class StudentController {

	// http://localhost:7788/api/students
	@GetMapping("/students")
	public StudentPojo getAStudent() {
		StudentPojo student = new StudentPojo(102, "Mark Williams", 70);
		return student;
	}
}
