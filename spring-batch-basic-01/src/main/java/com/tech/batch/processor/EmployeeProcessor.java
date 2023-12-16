package com.tech.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.tech.batch.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	Logger logger = LoggerFactory.getLogger(EmployeeProcessor.class);
	
	@Override
	public Employee process(final Employee employee) throws Exception {
		final Integer id = employee.getId();
		final String firstName = employee.getFirstName().toUpperCase();
		final String lastName = employee.getLastName().toUpperCase();
		final String email = employee.getEmail().toUpperCase();
		final Employee transformedEmployee = new Employee(id, firstName, lastName, email);
		logger.info("Transformed Employee ====> "+transformedEmployee);
		return transformedEmployee;
	}

}
