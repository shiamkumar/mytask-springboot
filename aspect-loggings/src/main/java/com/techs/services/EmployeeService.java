package com.techs.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.techs.entities.Employee;
import com.techs.exceptions.ResourceNotFoundException;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Optional<Employee> getEmployeeById(Long employeeId);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException;

	Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;

}
