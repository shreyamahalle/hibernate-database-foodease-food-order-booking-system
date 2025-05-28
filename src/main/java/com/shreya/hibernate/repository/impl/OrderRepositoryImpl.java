package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Order;
import com.shreya.hibernate.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public List<Order> retrieveOrders() {
        return List.of();
    }

    @Override
    public Order retrieveOrder(int id, String type) {
        return null;
    }

    @Override
    public boolean deleteOrder(int id) {
        return false;
    }

    @Override
    public boolean updateOrder(int id, String newType) {
        return false;
    }
}
