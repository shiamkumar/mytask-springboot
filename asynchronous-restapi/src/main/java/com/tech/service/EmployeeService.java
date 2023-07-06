package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tech.entity.Employee;
import com.tech.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Async("asyncExecutor")
	public void getEmployee() {
		try {
			log.info("Sleep() - Started");
			Thread.sleep(10000);
			log.info("Sleep() - Ended");

			List<Employee> response = employeeRepo.findAll();
			response.forEach(employee -> {
				log.info("Response Data: " + employee.toString());
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
