package com.school.studentservice.controller;

import java.util.List;

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

import com.school.studentservice.entity.Student;
import com.school.studentservice.services.Services;

@RestController
@RequestMapping("/studentrequest")
public class OtherAccessController {
	
	@Autowired
	Services studentService;
	
	
	
	//get all students
		@GetMapping
		public ResponseEntity<List<Student>> getAllStudent(){
			return ResponseEntity.ok(studentService.getAllStudent());
		}
	
	
	//add student controller
		@PostMapping
		public ResponseEntity<Student> addStudent( @RequestBody Student student){
			
			return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
		}
		
		// update student
		
		@PutMapping("/{username}")
		public ResponseEntity<String> updateStudent(@PathVariable String username,@RequestBody Student student){
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(username, student));
		}
		
		// Delete student
		@DeleteMapping("/{username}")
		public ResponseEntity<String> deleteStudent(@PathVariable String username){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.deleteStudent(username));
		}

}
