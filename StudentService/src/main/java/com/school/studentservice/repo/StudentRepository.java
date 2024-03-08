package com.school.studentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.studentservice.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

	Student findByUsername(String username);

}
