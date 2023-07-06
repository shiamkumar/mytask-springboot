package com.study;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.entity.Order;
import com.study.entity.OrderItem;
import com.study.repo.OrderRepository;

@SpringBootApplication
public class OnetomanyUnidirectionalApplication implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnetomanyUnidirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Set<OrderItem> orderItems = new HashSet<>();
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setImageUrl("image_url.png");
		orderItems.add(orderItem1);

		OrderItem orderItem2 = new OrderItem();
		orderItem2.setImageUrl("image_url2.png");
		orderItems.add(orderItem2);

		Order order = new Order();
		order.setOrderItems(orderItems);
		order.setTrackingNumber("1000");
		orderRepository.save(order);
	}

}
