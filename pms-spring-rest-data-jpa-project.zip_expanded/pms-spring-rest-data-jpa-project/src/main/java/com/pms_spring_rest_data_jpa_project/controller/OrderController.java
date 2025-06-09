package com.pms_spring_rest_data_jpa_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms_spring_rest_data_jpa_project.dao.entity.OrderEntity;
import com.pms_spring_rest_data_jpa_project.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderEntity>> getAllOrders(){
		List<OrderEntity> responseBody = orderService.getAllOrders();
		return new ResponseEntity<List<OrderEntity>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Optional<OrderEntity>> getAOrder(@PathVariable int orderId) {
		return new ResponseEntity<Optional<OrderEntity>>(orderService.getAOrder(orderId), HttpStatus.OK);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderEntity newOrder) {
		return new ResponseEntity<OrderEntity>(orderService.addOrder(newOrder), HttpStatus.OK);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<OrderEntity> updateOrder(@RequestBody OrderEntity editOrder) {
		return new ResponseEntity<OrderEntity>(orderService.updateOrder(editOrder), HttpStatus.OK);
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<Void> deleteOrder(int orderId) {
		orderService.deleteOrder(orderId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
