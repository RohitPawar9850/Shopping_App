package com.example.shopping.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.shopping.entity.Coupon;
import com.example.shopping.repository.CouponRepository;
import com.example.shopping.repository.UserRepository;

public class CouponServiceImpl {
	 // Mock coupon data
    private static final Map<String, Integer> coupons = new HashMap<>();
    static {
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
    }

    @Autowired
    private UserRepository userRepository; // Assuming you have a repository for User
    @Autowired
    private CouponRepository couponRepository; // Assuming you have a repository for Coupon

    public Coupon getCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }

    public boolean isCouponValid(String code) {
        Coupon coupon = couponRepository.findByCode(code);
        if (coupon == null || coupon.isUsed()) {
            return false; // Coupon does not exist or has already been used
        }
        return true;
    }

    public void markCouponAsUsed(String code) {
        Coupon coupon = couponRepository.findByCode(code);
        if (coupon != null) {
            coupon.setUsed(true);
            couponRepository.save(coupon);
        }
    }
}
