package com.tech.dto;

import java.util.List;

import com.tech.entity.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BulkEmployeesRequestDTO {

	private List<Employee> employees;

}
