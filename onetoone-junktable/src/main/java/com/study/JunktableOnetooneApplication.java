package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.entity.Customer;
import com.study.entity.Item;
import com.study.repo.CustomerRepo;

@SpringBootApplication
public class JunktableOnetooneApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepo customerRepo;

	public static void main(String[] args) {
		SpringApplication.run(JunktableOnetooneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Item itemObj = new Item();
		itemObj.setName("HP Laptop");

		Customer customerObj = new Customer();
		customerObj.setName("Arun");
		customerObj.setItem(itemObj);
		customerRepo.save(customerObj);
	}

}
