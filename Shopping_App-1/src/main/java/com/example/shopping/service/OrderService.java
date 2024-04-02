package com.example.shopping.service;

import java.util.List;

import com.example.shopping.entity.Order;

public interface OrderService {
	Order createOrder(Long userId);
    List<Order> getOrdersByUserId(Long userId);
    Order getOrderById(Long orderId);
    void processPayment(Long orderId, double amount);
}
