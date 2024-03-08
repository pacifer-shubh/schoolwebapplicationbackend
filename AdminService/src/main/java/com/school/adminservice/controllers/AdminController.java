package com.school.adminservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.adminservice.entity.Admin;
import com.school.adminservice.entity.AuthRequest;
import com.school.adminservice.services.AdminServices;
import com.school.adminservice.services.JwtService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	AdminServices adminServices;
	
	@PostMapping("/add")
	public String addAdmin(@RequestBody Admin admin) {
		
		return adminServices.addAdmin(admin);
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest ) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated())
		{
		
		return jwtService.generateToken(authRequest.getUsername());
		}
		else {
			throw new UsernameNotFoundException("invalid user request !");
		}
		
	}
	
	

}
