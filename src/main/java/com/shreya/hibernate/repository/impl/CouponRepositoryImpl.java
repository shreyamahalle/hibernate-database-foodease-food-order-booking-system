package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponRepositoryImpl {

    Coupon saveCoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
    Optional<Coupon> findById(long id);
    Coupon deleteCoupon(long id);
    Coupon updateCoupon(Coupon coupon);

}
