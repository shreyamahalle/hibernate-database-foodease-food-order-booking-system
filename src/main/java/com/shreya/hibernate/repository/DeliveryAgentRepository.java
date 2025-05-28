package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.DeliveryAgent;
import com.shreya.hibernate.repository.impl.DeliveryAgentRepositoryImpl;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaUpdate;
import java.util.List;

public interface DeliveryAgentRepository implements DeliveryAgentRepositoryImpl {

    boolean addDeliveryAgent(DeliveryAgent deliveryAgent);

    List<DeliveryAgent> retrieveDeliveryAgents();

    DeliveryAgent findById(int id);

    boolean deleteDeliveryAgent(int id);

    boolean updateDeliveryAgent(DeliveryAgent deliveryAgent);
}