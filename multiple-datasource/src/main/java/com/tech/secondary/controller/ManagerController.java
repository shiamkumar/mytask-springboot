package com.tech.secondary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.secondary.entity.Manager;
import com.tech.secondary.repo.ManagerRepository;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerRepository managerRepo;

	@GetMapping("/getAll")
	List<Manager> getManager() {
		return managerRepo.findAll();
	}

	@PostMapping("/add")
	List<Manager> addManager(@RequestBody Manager manager) {
		managerRepo.save(manager);
		return managerRepo.findAll();
	}

}
