package com.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	static List<Student> studentList = new ArrayList<Student>();
	static int studentId=1;
	
	public void addStudent(Student student) {
		student.setId(studentId);
		studentList.add(student);
		studentId++;
	}
	public List<Student> getAllStudentList(){
		return studentList;
	}
	
}
