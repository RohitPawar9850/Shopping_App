package com.example.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<?> createOrder(@PathVariable Long userId) {
        // Implement logic to create an order
        return ResponseEntity.ok(orderService.createOrder(userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<?> getOrderDetails(@PathVariable Long userId, @PathVariable Long orderId) {
        // Implement logic to get order details
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<?> processPayment(@PathVariable Long userId, @PathVariable Long orderId, @RequestParam double amount) {
        // Implement logic to process payment
        orderService.processPayment(orderId, amount);
        return ResponseEntity.ok("Payment processed successfully");
    }
}