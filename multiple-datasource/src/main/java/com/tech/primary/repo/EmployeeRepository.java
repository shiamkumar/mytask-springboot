package com.tech.primary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.primary.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
