package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.Coupon;
import com.shreya.hibernate.repository.impl.CouponRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CouponRepository implements CouponRepositoryImpl {

    private final Logger log = LoggerFactory.getLogger(CouponRepository.class);


    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return List.of();
    }

    @Override
    public Optional<Coupon> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Coupon deleteCoupon(long id) {
        return null;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        return null;
    }
}
