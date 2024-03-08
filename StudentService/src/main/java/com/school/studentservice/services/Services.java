package com.school.studentservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.school.studentservice.entity.Student;

public interface Services {

	//to add new student
	Student addStudent(Student student);
	
	//to update Student
	String updateStudent(String username, Student student);

	
	//to get student
	Student getStudentById(String username);
	
	//to delete student
	String deleteStudent(String username);

	//to get all students
	List<Student> getAllStudent();
	
	
}
