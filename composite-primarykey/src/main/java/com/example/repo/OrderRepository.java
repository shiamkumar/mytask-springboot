package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
