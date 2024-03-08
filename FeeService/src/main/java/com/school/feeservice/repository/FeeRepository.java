package com.school.feeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.feeservice.entities.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer> {
	
	public List<Fee> findByStudentId(String studentId);
	

}
