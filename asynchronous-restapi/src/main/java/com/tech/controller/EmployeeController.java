package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Employee;
import com.tech.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee createEmployee = employeeService.saveEmployee(employee);
		employeeService.getEmployee();
		return new ResponseEntity<Employee>(createEmployee, HttpStatus.CREATED);
	}
	
}
