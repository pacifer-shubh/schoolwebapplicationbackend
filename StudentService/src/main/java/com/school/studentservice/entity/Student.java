package com.school.studentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	
	@Id
	private String username;
	private String password;
	private String name;
	private String std;
	private int age;
	private String guardian;
	private long contact;
	
	
}
