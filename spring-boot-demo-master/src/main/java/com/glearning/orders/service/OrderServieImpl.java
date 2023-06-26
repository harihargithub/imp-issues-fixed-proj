package com.glearning.orders.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.orders.model.Order;
import com.glearning.orders.repo.OrderRepository;

@Service
public class OrderServieImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		//perform the business logic
		Order savedOrder = this.orderRepository.save(order);
		return savedOrder;
	}

	@Override
	public Set<Order> fetchAllOrders() {
		return Set.copyOf(this.orderRepository.findAll());
	}

	@Override
	public Order updateOrder(long id, Order order) {
		Order orderById = this.orderRepository.getById(id);
		if(orderById != null) {
			orderById.setName(order.getName());
			orderById.setPrice(order.getPrice());
			return this.orderRepository.save(orderById);
		}
		throw new IllegalArgumentException("invalid order id passed");
	}

	@Override
	public void deleteOrder(long id) {
		Order orderById = this.orderRepository.getById(id);
		if(orderById != null) {
			this.orderRepository.delete(orderById);
		}
	}

	@Override
	public Order findOrderById(long id) {
		Optional<Order> optionalOrder = this.orderRepository.findById(id);
		if(optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		throw new IllegalArgumentException("invalid order id passed");
	}

}
