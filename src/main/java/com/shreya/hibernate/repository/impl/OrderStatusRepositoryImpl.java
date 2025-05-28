package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.OrderStatus;
import com.shreya.hibernate.repository.OrderStatusRepository;

import java.util.List;

public class OrderStatusRepositoryImpl implements OrderStatusRepository {
    @Override
    public boolean addOrderStatus(OrderStatus orderStatus) {
        return false;
    }

    @Override
    public List<OrderStatus> retrieveOrderStatuses() {
        return List.of();
    }

    @Override
    public OrderStatus retrieveOrderStatus(long id) {
        return null;
    }

    @Override
    public boolean updateOrderStatus(OrderStatus orderStatus) {
        return false;
    }

    @Override
    public boolean deleteOrderStatus(long id) {
        return false;
    }
}
