package com.school.messageservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.messageservice.entities.Message;
import com.school.messageservice.repositories.MessageRepository;

@Service
public class MessageServices {

	@Autowired
	MessageRepository repo;
	
	
	// to add message 
	public Message addMessage(Message message) {
		return repo.save(message);
	}
	
	//to get message by studentId
	public List<Message> getMessageByStudentId(String studentId){
		
		return repo.findByStudentId(studentId);
	}
	
	//to get message by TeacherId
	public List<Message> getMessageByTeacherId(String teacherId){
		return repo.findByTeacherId(teacherId);
	}
	
	// to delete by id
	public String deleteMessage(int id) {
		
		repo.deleteById(id);
		
		return "delete";
	}
}
