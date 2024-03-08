package com.school.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.adminservice.entity.Admin;
import com.school.adminservice.repositories.AdminRepository;

@Service
public class AdminServices {
	
	@Autowired
	private BCryptPasswordEncoder byCryptPasswordEncoder;
	

	@Autowired
	AdminRepository adminRepository;
	
	
	// to add new admin
	public String addAdmin(Admin admin) {
		
		admin.setPassword(this.byCryptPasswordEncoder.encode(admin.getPassword()));
		adminRepository.save(admin);
		
		return "added";
	
	}
	
	

}
