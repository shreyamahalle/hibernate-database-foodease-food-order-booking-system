package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.DeliveryAgent;
import com.shreya.hibernate.service.DeliveryAgentService;

import java.sql.SQLException;
import java.util.List;

public class DeliveryAgentRepositoryImpl implements DeliveryAgentService {


    @Override
    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return false;
    }

    @Override
    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteDeliveryAgent(int id) throws SQLException {
        return false;
    }

    @Override
    public DeliveryAgent getDeliveryAgentById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<DeliveryAgent> retrieveAllDeliveryAgents() throws SQLException {
        return List.of();
    }
}
