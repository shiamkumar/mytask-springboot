package com.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tech.entity.Address;
import com.tech.repo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addAddressTo(Address address) {
		addressRepo.save(address);
	}

}
