package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.DeliveryAgent;
import com.shreya.hibernate.repository.DeliveryAgentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deliveryAgentRepository")
public class DeliveryAgentRepositoryImpl implements DeliveryAgentRepository {

    private final SessionFactory sessionFactory;

    public DeliveryAgentRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(deliveryAgent);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<DeliveryAgent> retrieveDeliveryAgents() {
        Session session = sessionFactory.openSession();
        Query<DeliveryAgent> query = session.createQuery("from DeliveryAgent", DeliveryAgent.class);
        List<DeliveryAgent> agents = query.list();
        session.close();
        return agents;
    }

    @Override
    public DeliveryAgent findById(int id) {
        Session session = sessionFactory.openSession();
        DeliveryAgent deliveryAgent = session.get(DeliveryAgent.class, id);
        session.close();
        return deliveryAgent;
    }

    @Override
    public boolean deleteDeliveryAgent(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DeliveryAgent deliveryAgent = session.load(DeliveryAgent.class, id);
        if (deliveryAgent != null) {
            session.delete(deliveryAgent);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DeliveryAgent existing = session.get(DeliveryAgent.class, deliveryAgent.getId());
        if (existing != null) {
            session.merge(deliveryAgent);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
