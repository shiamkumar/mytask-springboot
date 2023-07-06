package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.BulkEmployeesRequestDTO;
import com.tech.entity.Employee;
import com.tech.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/bulkEmployees")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody BulkEmployeesRequestDTO bulkEmployeesRequestDTO) {
		return employeeService.addEmployee(bulkEmployeesRequestDTO);
	}
	
}
