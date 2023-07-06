package com.study.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.study.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {
	
	@NotBlank
	@NotNull
	private int id;
	
	@NotBlank
	@NotNull
	private String name;
	
	@NotBlank
	@NotNull
	private Customer customer;
	
}
