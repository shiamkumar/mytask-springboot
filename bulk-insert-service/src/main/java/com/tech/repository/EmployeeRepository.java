package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
