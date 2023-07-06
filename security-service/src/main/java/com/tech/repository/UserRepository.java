package com.tech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsername(String username);
	
    Boolean existsByUsername(String username);
    
    Boolean existsByEmail(String email);
    
}
