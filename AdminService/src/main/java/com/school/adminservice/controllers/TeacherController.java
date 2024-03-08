package com.school.adminservice.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
import com.school.adminservice.dto.Teacher;

@RestController
@RequestMapping("/admin/teacher")
@CrossOrigin("*")
public class TeacherController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@GetMapping("/test")
	public String gettesting() {
		return "You've successfully implemented security, Hurrayyy!!!!";
	}

	
	@GetMapping
	public ArrayList getTeacher() {
		
		ArrayList forObject = restTemplate.getForObject("http://localhost:8082/teacher",ArrayList.class);
		
		
				return forObject;
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Teacher> addStudent(@RequestBody Teacher teacher) throws URISyntaxException {
		
		URI uri = new URI("http://localhost:8082/teacher");
		
		ResponseEntity<Teacher> result =	restTemplate.postForEntity(uri, teacher,Teacher.class);
		
		
		return result;
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Teacher teacher) throws URISyntaxException {
		
		URI uri = new URI("http://localhost:8082/teacher/"+ teacher.getUsername());
		
			restTemplate.put(uri, teacher);
		
		
		return "done";
	}
	

}
