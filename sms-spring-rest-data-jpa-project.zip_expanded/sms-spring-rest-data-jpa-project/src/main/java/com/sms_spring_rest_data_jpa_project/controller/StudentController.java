package com.sms_spring_rest_data_jpa_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms_spring_rest_data_jpa_project.entity.StudentEntity;
import com.sms_spring_rest_data_jpa_project.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studService;
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentEntity>> getAllStudents(){
		List<StudentEntity> responseBody = studService.getAllStudents();
		return new ResponseEntity<List<StudentEntity>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentId}")
	public ResponseEntity<Optional<StudentEntity>> getAStudent(@PathVariable int studentId) {
		return new ResponseEntity<Optional<StudentEntity>>(studService.getAStudent(studentId), HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity newStudent) {
		return new ResponseEntity<StudentEntity>(studService.addStudent(newStudent), HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity editStudent) {
		return new ResponseEntity<StudentEntity>(studService.updateStudent(editStudent), HttpStatus.OK);
	}
	
	@DeleteMapping("/students")
	public ResponseEntity<Void> deleteStudent(int studentId) {
		studService.deleteStudent(studentId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
