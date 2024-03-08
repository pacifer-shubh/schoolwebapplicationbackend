package com.school.teacherservice.entity;

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
public class Teacher {
	
	@Id
	private String username;
	private String password;
	private String name;
	private String subject;
	private int age;
	private int experience;
}
