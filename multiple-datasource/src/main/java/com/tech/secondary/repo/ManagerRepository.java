package com.tech.secondary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.secondary.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
