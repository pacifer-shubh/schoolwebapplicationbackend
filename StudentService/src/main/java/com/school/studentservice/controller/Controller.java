package com.school.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.school.studentservice.entity.Student;
import com.school.studentservice.services.JwtService;
import com.school.studentservice.services.Services;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	Services studentService;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	// student detail by Id
	
	@GetMapping("/{username}")
	public ResponseEntity<Student> getStudentById(@PathVariable String username){
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.getStudentById(username));

	}

	// update student
	
	@PutMapping("/{username}")
	public ResponseEntity<String> updateStudent(@PathVariable String username,@RequestBody Student student){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(username, student));
	}
	
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody com.school.studentservice.entity.AuthRequest authRequest ) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated())
		{
		
		return jwtService.generateToken(authRequest.getUsername());
		}
		else {
			throw new UsernameNotFoundException("invalid user request !");
		}
		
	}
	
}
