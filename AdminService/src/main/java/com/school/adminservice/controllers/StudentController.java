package com.school.adminservice.controllers;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.school.adminservice.dto.Student;

@RestController
@RequestMapping("/admin/students")
@CrossOrigin("*")
public class StudentController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@GetMapping("/test")
	public String gettesting() {
		return "You've successfully implemented security, Hurrayyy!!!!";
	}

	
	@GetMapping
	public ArrayList getStudent() {
		
		ArrayList forObject = restTemplate.getForObject("http://localhost:8081/studentrequest",ArrayList.class);
		
		
				return forObject;
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws URISyntaxException {
		
		URI uri = new URI("http://localhost:8081/studentrequest");
		
		ResponseEntity<Student> result =	restTemplate.postForEntity(uri, student,Student.class);
		
		
		return result;
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) throws URISyntaxException {
		
		URI uri = new URI("http://localhost:8081/studentrequest/"+ student.getUsername());
		
			restTemplate.put(uri, student);
		
		
		return "done";
	}
}
