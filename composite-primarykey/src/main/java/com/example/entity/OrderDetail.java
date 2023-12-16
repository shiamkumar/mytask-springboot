package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "order_details")
public class OrderDetail {
	@EmbeddedId
	private OrderDetailID id;

	private int quantity;

	@Column(name = "unit_price")
	private float unitPrice;

	private float subtotal;
}
