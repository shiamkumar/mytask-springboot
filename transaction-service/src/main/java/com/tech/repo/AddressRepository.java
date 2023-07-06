package com.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
