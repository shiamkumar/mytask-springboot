package com.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empSeq")
    @SequenceGenerator(name = "empSeq", sequenceName = "employee_seq", initialValue = 1, allocationSize = 1)
	private int id;
	private String name;
	private String role;
	
}
