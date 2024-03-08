package com.school.teacherservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.teacherservice.entity.Teacher;
import com.school.teacherservice.services.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class Controller {
	
	
	@Autowired
	TeacherService service;
	
	
	@GetMapping
	public ResponseEntity<List<Teacher>> getAllTeacher(){
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAllTeacher());
	}
	
	
	@GetMapping("/{username}")
	public ResponseEntity<Teacher> getTeacherByUsername( @PathVariable String username){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getTeacherByUsername(username));
		
	}
	
	@PostMapping
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addTeacher(teacher));
	}
	
	@PutMapping("/{username}")
	public ResponseEntity<String> updateTeacher(@PathVariable String username, @RequestBody Teacher teacher){
		
		return ResponseEntity.ok(service.updateTeacher(username, teacher));
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<String> deleteTeacher(@PathVariable String username){
		return ResponseEntity.ok(service.deleteTeacher(username));
	}

}
