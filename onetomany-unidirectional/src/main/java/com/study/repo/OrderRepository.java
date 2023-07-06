package com.study.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
