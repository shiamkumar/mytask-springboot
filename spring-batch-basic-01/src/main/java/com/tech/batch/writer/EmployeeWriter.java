package com.tech.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.tech.batch.entity.Employee;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

	@Override
	public void write(List<? extends Employee> employees) throws Exception {
		for (Employee data : employees) {
			System.out.println("Employee Data Writing:: " + data.getId()+" : "+data.getFirstName()+" : "+data.getLastName()+" : "+data.getEmail() );
		}
	}

}
