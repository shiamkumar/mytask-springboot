package com.tech.primary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.primary.entity.Employee;
import com.tech.primary.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/getAll")
	List<Employee> getEmployee() {
		return employeeRepo.findAll();
	}

	@PostMapping("/add")
	List<Employee> addEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return employeeRepo.findAll();
	}

}
