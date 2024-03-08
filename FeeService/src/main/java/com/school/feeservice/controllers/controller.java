package com.school.feeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.feeservice.entities.Fee;
import com.school.feeservice.exceptions.ResourceNotFoundException;
import com.school.feeservice.services.FeeServices;

@RestController
@RequestMapping("/fees")
@CrossOrigin("*")
public class controller {
	
	@Autowired
	FeeServices feeServices;
	
	
	@PostMapping
	public ResponseEntity<Fee> addFee(@RequestBody Fee fee)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(feeServices.addFee(fee));
	}
	
	@GetMapping("{studentId}")
	public ResponseEntity<List<Fee>> getFeeByStudentId(@PathVariable String studentId)
	{
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(feeServices.getFeeByStudentId(studentId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateFee(@PathVariable int id)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(feeServices.updateFee(id));
	}

	
	
}
