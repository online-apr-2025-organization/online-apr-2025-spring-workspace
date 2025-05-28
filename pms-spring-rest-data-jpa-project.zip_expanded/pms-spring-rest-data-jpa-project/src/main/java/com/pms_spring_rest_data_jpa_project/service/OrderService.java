package com.pms_spring_rest_data_jpa_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms_spring_rest_data_jpa_project.dao.OrderDao;
import com.pms_spring_rest_data_jpa_project.dao.entity.OrderEntity;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	public List<OrderEntity> getAllOrders(){
		return orderDao.findAll();
	}
	
	public Optional<OrderEntity> getAOrder(int orderId) {
		return orderDao.findById(orderId);
	}
	
	public OrderEntity addOrder(OrderEntity newOrder) {
		return orderDao.saveAndFlush(newOrder);
	}
	
	public OrderEntity updateOrder(OrderEntity editOrder) {
		return orderDao.saveAndFlush(editOrder);
	}
	
	public void deleteOrder(int orderId) {
		orderDao.deleteById(orderId);
	}
}
