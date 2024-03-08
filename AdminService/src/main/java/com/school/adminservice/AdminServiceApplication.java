package com.school.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.school.adminservice.entity.Admin;
import com.school.adminservice.repositories.AdminRepository;

@SpringBootApplication
public class AdminServiceApplication implements CommandLineRunner {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private BCryptPasswordEncoder byCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Admin user = new Admin();
	
		user.setUsername("admin@shubham");
		user.setPassword(this.byCryptPasswordEncoder.encode("admin@shubham"));
		user.setName("Shubham Singh");
		
		this.adminRepository.save(user);
	}
}
