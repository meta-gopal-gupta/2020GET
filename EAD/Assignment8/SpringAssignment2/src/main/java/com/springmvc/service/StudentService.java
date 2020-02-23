package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.Student;
import com.springmvc.dao.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	
	public List<Student> getAllStudentList(){
		return studentDao.getAllStudentList();
	}

}
