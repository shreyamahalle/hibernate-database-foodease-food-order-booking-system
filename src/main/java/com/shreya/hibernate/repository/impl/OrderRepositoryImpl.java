package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Order;
import com.shreya.hibernate.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final SessionFactory sessionFactory;

    public OrderRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Order> retrieveOrders() {
        Session session = sessionFactory.openSession();
        Query<Order> query = session.createQuery("from Order", Order.class);
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }

    @Override
    public Order retrieveOrder(int id, String type) {
        Session session = sessionFactory.openSession();
        Query<Order> query = session.createQuery(
                "from Order where id = :id and type = :type", Order.class);
        query.setParameter("id", id);
        query.setParameter("type", type);
        Order order = query.uniqueResult();
        session.close();
        return order;
    }

    @Override
    public boolean deleteOrder(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        if (order != null) {
            session.delete(order);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateOrder(int id, String newType) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        if (order != null) {
            order.setType(newType);
            session.update(order);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
