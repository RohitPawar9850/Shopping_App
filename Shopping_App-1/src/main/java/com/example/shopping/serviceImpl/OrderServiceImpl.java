package com.example.shopping.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.shopping.entity.Order;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.service.CouponService;
import com.example.shopping.service.ProductService;

public class OrderServiceImpl {
	 @Autowired
	    private OrderRepository orderRepository; // Assuming you have a repository for Order
	    @Autowired
	    private ProductService productService; // Assuming you have a ProductService bean
	    @Autowired
	    private CouponService couponService; // Assuming you have a CouponService bean

	    public Order createOrder(Long userId, int quantity, String couponCode) {
	        // Check if the product is available in the desired quantity
	        boolean isAvailable = productService.checkProductAvailability(productId, quantity);
	        if (!isAvailable) {
	            throw new RuntimeException("Invalid quantity");
	        }

	        // Check if the coupon is valid
	        boolean isValidCoupon = couponService.isCouponValid(couponCode);
	        if (!isValidCoupon) {
	            throw new RuntimeException("Invalid coupon");
	        }

	        // Calculate the total amount with discount
	        double price = productService.getProductById(userId).getPrice();
	        double discountPercentage = couponService.getCouponByCode(couponCode).getDiscountPercentage();
	        double amount = price * quantity * (1 - discountPercentage / 100);

	        // Create and save the order
	        Order order = new Order();
	        order.setUserId(userId);
	        order.setQuantity(quantity);
	        order.setAmount(amount);
	        order.setCouponCode(couponCode);
	        order.setDate(LocalDateTime.now());
	        orderRepository.save(order);

	        // Mark the coupon as used
	        couponService.markCouponAsUsed(couponCode);

	        return order;
	    }

	    public List<Order> getOrdersByUserId(Long userId) {
	        return orderRepository.findByUserId(userId);
	    }

	    public Order getOrderById(Long orderId) {
	        return orderRepository.findById(orderId)
	                .orElseThrow(() -> new RuntimeException("Order not found"));
	    }

	    public void processPayment(Long orderId, double amount) {
	        
	    }
}
