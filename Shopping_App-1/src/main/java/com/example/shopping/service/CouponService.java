package com.example.shopping.service;

import com.example.shopping.entity.Coupon;

public interface CouponService {
	  Coupon getCouponByCode(String code);
	    boolean isCouponValid(String code);
	    void markCouponAsUsed(String code);
}
