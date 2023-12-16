package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderDetail;
import com.example.entity.OrderDetailID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailID> {

}
