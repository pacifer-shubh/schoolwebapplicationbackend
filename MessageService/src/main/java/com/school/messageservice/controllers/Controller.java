package com.school.messageservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.messageservice.entities.Message;
import com.school.messageservice.services.MessageServices;

@RestController
@RequestMapping("/message")
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	MessageServices service;
	
	//to add message
	
	@PostMapping
	public ResponseEntity<Message> addMessage(@RequestBody Message message){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addMessage(message));
	}
	
	//to get message by StudentId
	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<Message>> getMessageByStudentId(@PathVariable String studentId){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getMessageByStudentId(studentId));
	}
	
	//to get message by TeacherId
		@GetMapping("/teacher/{teacherId}")
		public ResponseEntity<List<Message>> getMessageByteacherId(@PathVariable String teacherId){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getMessageByTeacherId(teacherId));
		}
	
	// to delete message by id
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMessage(@PathVariable int id){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.deleteMessage(id));
		
	}
	
	
}
