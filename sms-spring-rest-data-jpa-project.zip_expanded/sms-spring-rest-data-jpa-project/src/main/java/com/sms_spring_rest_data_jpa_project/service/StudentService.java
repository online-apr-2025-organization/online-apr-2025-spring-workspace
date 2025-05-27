package com.sms_spring_rest_data_jpa_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms_spring_rest_data_jpa_project.dao.StudentDao;
import com.sms_spring_rest_data_jpa_project.entity.StudentEntity;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studDao;
	
	public List<StudentEntity> getAllStudents(){
		return studDao.findAll();
	}
	
	public Optional<StudentEntity> getAStudent(int studentId) {
		return studDao.findById(studentId);
	}
	
	public StudentEntity addStudent(StudentEntity newStudent) {
		return studDao.saveAndFlush(newStudent);
	}
	
	public StudentEntity updateStudent(StudentEntity editStudent) {
		return studDao.saveAndFlush(editStudent);
	}
	
	public void deleteStudent(int studentId) {
		studDao.deleteById(studentId);
	}
}
