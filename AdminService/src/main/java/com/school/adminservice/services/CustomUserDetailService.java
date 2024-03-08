package com.school.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.school.adminservice.entity.Admin;
import com.school.adminservice.repositories.AdminRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admin user = this.adminRepository.findByUsername(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("NO USER");
		}
		
		return new CustomUserDetail(user);
	}

}