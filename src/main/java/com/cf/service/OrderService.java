package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dao.OrderDao;
import com.cf.entity.Order;
import com.cf.utils.Page;
import com.cf.vo.UserAndSups;

@Service
public class OrderService {
	@Autowired
	OrderDao orderDao;

	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
	}

	public Order getById(int id) {
		return orderDao.getById(id);
	}

	public List<Order> listOrders(Page page) {
		return orderDao.listOrders(page);
	}

	public List<UserAndSups> getOrdersByUserId(int id) {
		return orderDao.getOrdersByUserId(id);
	}

	public List<Order> getOrdersPayed(int id) {
		return orderDao.getOrdersPayed(id);
	}

	public List<Order> getOrdersNoPayed(int id) {
		return orderDao.getOrdersNoPayed(id);
	}

	public List<Order> getOrdersByProId(int id) {
		return orderDao.getOrdersByProId(id);
	}

	public void updateState(String orderId) {
		orderDao.updateState(orderId);
	}
	//2018 7 8 new
	
	public void deleteOrder(Integer id) {
		orderDao.deleteOrder(id);
	}
	
	//2018 7 12
	public Order getOrderByOrderId(String orderId) {
		return orderDao.getOrdersByOrderId(orderId);
	}
}
