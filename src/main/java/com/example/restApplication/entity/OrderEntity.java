package com.example.restApplication.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

//@Entity
//@Table(name = "orders")
@Data
public class OrderEntity {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderName;
	private BigDecimal  amount;
	private LocalDateTime createdAt;
	

}
