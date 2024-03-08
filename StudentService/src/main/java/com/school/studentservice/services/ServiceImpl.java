package com.school.studentservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.studentservice.entity.Student;
import com.school.studentservice.exceptions.ResourceNotFoundException;
import com.school.studentservice.repo.StudentRepository;

@Service
public class ServiceImpl implements Services{
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private BCryptPasswordEncoder byCryptPasswordEncoder;
	
	
	@Override
	public List<Student> getAllStudent(){
		List<Student> students = studentRepo.findAll();
		
		return students;
	}

	@Override
	public Student addStudent(Student student) {
		student.setPassword(this.byCryptPasswordEncoder.encode(student.getPassword()));
		return studentRepo.save(student);
	}

	@Override
	public String updateStudent(String username, Student student) {
		if(studentRepo.existsById(username))
		{
			student.setUsername(username);
			Student st = studentRepo.findById(username).orElseThrow(()-> new ResourceNotFoundException("Student with Id:"+ username +" is not found"));
			student.setPassword(st.getPassword());
			 studentRepo.save(student);
			 return "Updated";
		}
		return "Failed";
	}

	@Override
	public Student getStudentById(String username) {
		Student student = studentRepo.findById(username).orElseThrow(()-> new ResourceNotFoundException("Student with Id:"+ username +" is not found"));
		student.setPassword(null);
		return student ;
	}

	@Override
	public String deleteStudent(String username) {
		studentRepo.deleteById(username);
		return "Deleted";
	}

	
	
	
	
}
