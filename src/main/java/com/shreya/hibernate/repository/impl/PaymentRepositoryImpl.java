package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Payment;
import com.shreya.hibernate.repository.PaymentRepository;

import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public boolean addPayment(Payment payment) {
        return false;
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }

    @Override
    public Payment findById(int id) {
        return null;
    }

    @Override
    public boolean update(Payment payment) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
