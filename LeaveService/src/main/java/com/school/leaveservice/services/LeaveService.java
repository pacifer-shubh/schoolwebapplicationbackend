package com.school.leaveservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.leaveservice.entities.LeaveEntity;
import com.school.leaveservice.repositories.LeaveRepository;

@Service
public class LeaveService {
	
	
	@Autowired
	LeaveRepository leaveRepository;
	
	public List<LeaveEntity> getLeaveByUsername(String studentId) {
			
		List<LeaveEntity> leaves = leaveRepository.findByStudentId(studentId);
		
		return leaves;
	}
	
	public LeaveEntity addLeave(LeaveEntity leaveEntity)
	{
		leaveEntity.setApproved(false);
		return leaveRepository.save(leaveEntity);
	}
	
	public String updated(LeaveEntity leaveEntity,int id)
	{
		LeaveEntity leaveUp=leaveRepository.findById(id).orElseThrow(()-> new com.school.leaveservice.exceptions.ResourceNotFoundException("LeaveEntity with Id:"+ id +" is not found"));
		leaveUp.setApproved(leaveEntity.getApproved());
		leaveRepository.save(leaveUp);
		return "updated";
	}

}
