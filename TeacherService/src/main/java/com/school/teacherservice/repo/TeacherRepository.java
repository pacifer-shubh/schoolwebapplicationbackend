package com.school.teacherservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.teacherservice.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
