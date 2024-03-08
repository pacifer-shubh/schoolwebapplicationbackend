package com.school.leaveservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.leaveservice.entities.LeaveEntity;

public interface LeaveRepository extends JpaRepository<LeaveEntity, Integer>{

	
	List<LeaveEntity> findByStudentId(String studentId);
}
