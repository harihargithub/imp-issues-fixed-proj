package com.glearning.orders.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.orders.model.Order;
import com.glearning.orders.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
	
	@Autowired
	public OrderService orderService;
	
	/*
	 * Get - Fetch the orders
	 * Post - To create the order
	 * Put - To update the order
	 * Delete - To delete the order
	 */
	
	@GetMapping
	public Set<Order> fetchAllOrders(){
		return this.orderService.fetchAllOrders();
	}
	
	@GetMapping("/{id}")
	public Order fetchOrderById(@PathVariable("id") long id) {
		return this.orderService.findOrderById(id);
	}
	
	@PostMapping
	public Order saveUser(@RequestBody Order order) {
		return this.orderService.saveOrder(order);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable("id") long id) {
		this.orderService.deleteOrder(id);
	}

}
