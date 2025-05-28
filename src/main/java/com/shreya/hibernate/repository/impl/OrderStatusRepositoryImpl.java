package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.OrderStatus;
import com.shreya.hibernate.repository.OrderStatusRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderStatusRepositoryImpl implements OrderStatusRepository {

    private final SessionFactory sessionFactory;

    public OrderStatusRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addOrderStatus(OrderStatus orderStatus) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orderStatus);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<OrderStatus> retrieveOrderStatuses() {
        Session session = sessionFactory.openSession();
        Query<OrderStatus> query = session.createQuery("from OrderStatus", OrderStatus.class);
        List<OrderStatus> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public OrderStatus retrieveOrderStatus(long id) {
        Session session = sessionFactory.openSession();
        OrderStatus orderStatus = session.get(OrderStatus.class, id);
        session.close();
        return orderStatus;
    }

    @Override
    public boolean updateOrderStatus(OrderStatus orderStatus) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(orderStatus);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteOrderStatus(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        OrderStatus orderStatus = session.get(OrderStatus.class, id);
        if (orderStatus != null) {
            session.delete(orderStatus);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
