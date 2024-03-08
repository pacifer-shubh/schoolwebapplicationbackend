package com.school.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private String username;
	private String password;
	private String name;
	private String std;
	private int age;
	private String guardian;
	private long contact;
	
	
}
