package com.example.restApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApplication.entity.OrderEntity;
import com.example.restApplication.services.RestService;

@RestController
public class restController {
	
	@Autowired
	RestService restService;
	
	@GetMapping("fetchOrdersFromDB/{id}")
	public ResponseEntity<OrderEntity> getOrdersFromDb(@PathVariable Long id){
		OrderEntity entity= restService.getOrder(id);
		return ResponseEntity.ok(entity);
	}
	
	@PostMapping("insertOrderData")
	public ResponseEntity<OrderEntity> insertOrder(@RequestBody OrderEntity orderEntity){
		OrderEntity entity= restService.insertOrder(orderEntity);
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("getString")
	public void getString() {
		restService.newString(null);
	}

}
