package com.school.feeservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.feeservice.entities.Fee;
import com.school.feeservice.exceptions.ResourceNotFoundException;
import com.school.feeservice.repository.FeeRepository;

@Service
public class FeeServices {

	
	@Autowired
	private FeeRepository feeRepository;
	
	public Fee addFee(Fee fee) //add fees
	{
		fee.setPaid(false);
	  return feeRepository.save(fee);
		
	}
	
	public List<Fee> getFeeByStudentId(String studentId)
	{
		return feeRepository.findByStudentId(studentId);
	}
	
	public String updateFee(int id)
	{
		Fee fee=feeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Fee with Id:"+ id +" is not found"));
	
		fee.setPaid(true);
		feeRepository.save(fee);
		return "Updated";
	}
}
