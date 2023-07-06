package com.tech.secondary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "managers")
public class Manager {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private int salary;

}
