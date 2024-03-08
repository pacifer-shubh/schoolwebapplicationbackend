package com.school.studentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.school.studentservice.entity.Student;
import com.school.studentservice.repo.StudentRepository;



@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private StudentRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Student user = this.adminRepository.findByUsername(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("NO USER");
		}
		
		return new CustomUserDetail(user);
	}

}