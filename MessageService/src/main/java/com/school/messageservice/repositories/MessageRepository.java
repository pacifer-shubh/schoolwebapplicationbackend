package com.school.messageservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.messageservice.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	
	public List<Message> findByStudentId(String studentId);
	public List<Message> findByTeacherId(String teacherId);

}
