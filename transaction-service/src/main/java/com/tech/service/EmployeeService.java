package com.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tech.entity.Address;
import com.tech.entity.Employee;
import com.tech.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private AddressService addressService;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Transactional(propagation = Propagation.REQUIRED)
	public Employee addEmployee(Employee employee) throws Exception {
		Employee savedEmployee = employeeRepo.save(employee);

		Address address = new Address();
		address.setId(1L);
		address.setAddressLine("Gandhi Street");
		address.setCity("Chennai");
		//address.setEmployee(savedEmployee);
		addressService.addAddressTo(address);
		
		return savedEmployee;
	}

}
