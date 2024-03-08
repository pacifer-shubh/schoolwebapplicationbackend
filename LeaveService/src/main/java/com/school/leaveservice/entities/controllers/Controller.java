package com.school.leaveservice.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.leaveservice.entities.LeaveEntity;
import com.school.leaveservice.services.LeaveService;

@RestController
@RequestMapping("/leave")
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	LeaveService leaveService;
	
	@GetMapping("/{id}")
	public List<LeaveEntity> getLeaveByStudentId(@PathVariable String id){
		return leaveService.getLeaveByUsername(id);
	}

	@PostMapping
	public ResponseEntity<LeaveEntity> addLeave( @RequestBody LeaveEntity leaveEntity)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(leaveService.addLeave(leaveEntity));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateLeave(@PathVariable int id, @RequestBody LeaveEntity leaveEntity){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(leaveService.updated(leaveEntity, id));
	}
	
	
}
