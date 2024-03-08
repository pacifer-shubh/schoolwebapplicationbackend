package com.school.adminservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

	private String username;
	private String password;
	private String name;
	private String subject;
	private int age;
	private int experience;
}