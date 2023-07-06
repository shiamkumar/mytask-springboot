package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.Customer;
import com.study.entity.Item;
import com.study.repo.CustomerRepo;
import com.study.request.CustomerRequest;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequest customerRequest) {
		Item itemObj = new Item();
		itemObj.setName(customerRequest.getItem().getName());

		Customer customerObj = new Customer();
		customerObj.setName(customerRequest.getName());
		customerObj.setItem(itemObj);
		customerRepo.save(customerObj);
		return new ResponseEntity<>(customerObj, HttpStatus.CREATED);
	}
	
}
