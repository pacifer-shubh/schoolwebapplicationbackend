package com.school.leaveservice.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class LeaveEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	String studentId;
	String reasondefined;
	String reason;
	LocalDate startDate;
	LocalDate endDate;
	Boolean approved;

}
