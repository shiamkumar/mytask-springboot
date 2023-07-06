package com.tech.service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.dto.BulkEmployeesRequestDTO;
import com.tech.entity.Employee;
import com.tech.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public ResponseEntity<List<Employee>> addEmployeeRealData(BulkEmployeesRequestDTO bulkEmployeesRequestDTO) {	
		List<Employee> employeesList = new ArrayList<>();
		bulkEmployeesRequestDTO.getEmployees().forEach(each -> {
			Employee emp = new Employee();
			emp.setName(each.getName());
			emp.setRole(each.getRole());
			employeesList.add(emp);
		});
		employeeRepo.saveAll(employeesList);
		return null;
	}

	public ResponseEntity<List<Employee>> addEmployee(BulkEmployeesRequestDTO bulkEmployeesRequestDTO) {
		Instant start = Instant.now();
		List<Employee> employeesList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			Employee emp = new Employee();
			emp.setName("book-" + i);
			emp.setRole("book-" + i);
			employeesList.add(emp);
		}
		employeeRepo.saveAll(employeesList);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		log.info("Time taken:: " + timeElapsed.toMillis() + " milliseconds");
		return null; 
	}

}
