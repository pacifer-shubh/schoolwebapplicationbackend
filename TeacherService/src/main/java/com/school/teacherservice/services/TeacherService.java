package com.school.teacherservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.teacherservice.entity.Teacher;
import com.school.teacherservice.exceptions.ResourceNotFoundException;
import com.school.teacherservice.repo.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	// to add new teacher
	public Teacher addTeacher(Teacher teacher) {
		
		return teacherRepository.save(teacher);
	}
	
	//to get all teachers
	public List<Teacher> getAllTeacher(){
		
		return teacherRepository.findAll();
	}
	
	//to get teacher by id
	public Teacher getTeacherByUsername(String username) {
		
		return teacherRepository.findById(username).orElseThrow(()-> new ResourceNotFoundException("Teacher with Id:"+ username +" is not found"));
	}
	
	// to update teacher
	public String updateTeacher(String username, Teacher teacher) {
		if(teacherRepository.existsById(username))
		{
			teacher.setUsername(username);
			Teacher tt = teacherRepository.findById(username).orElseThrow(()-> new ResourceNotFoundException("Student with Id:"+ username +" is not found"));
			teacher.setPassword(tt.getPassword());
			 teacherRepository.save(teacher);
			 return "Updated";
		}
		return "failed";
	}

	
	//to delete teacher 
	public String  deleteTeacher(String username) {
		
		teacherRepository.deleteById(username);
		
		return "deleted";
	}
	
	
}
