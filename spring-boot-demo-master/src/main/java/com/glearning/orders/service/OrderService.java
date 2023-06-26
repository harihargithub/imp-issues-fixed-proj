package com.glearning.orders.service;

import java.util.Set;

import com.glearning.orders.model.Order;

public interface OrderService {
	
	Order saveOrder(Order order);
	
	Set<Order> fetchAllOrders();
	
	Order findOrderById(long id);
	
	Order updateOrder(long id, Order order);
	
	void deleteOrder(long id);

}
