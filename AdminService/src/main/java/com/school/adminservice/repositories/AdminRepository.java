package com.school.adminservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.adminservice.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{

	Admin findByUsername(String username);
	
	

}
