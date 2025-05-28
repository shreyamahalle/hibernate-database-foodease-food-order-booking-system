package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Payment;
import com.shreya.hibernate.repository.PaymentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final SessionFactory sessionFactory;

    public PaymentRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addPayment(Payment payment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(payment);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Payment> findAll() {
        Session session = sessionFactory.openSession();
        Query<Payment> query = session.createQuery("from Payment", Payment.class);
        List<Payment> payments = query.getResultList();
        session.close();
        return payments;
    }

    @Override
    public Payment findById(int id) {
        Session session = sessionFactory.openSession();
        Payment payment = session.get(Payment.class, id);
        session.close();
        return payment;
    }

    @Override
    public boolean update(Payment payment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(payment);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Payment payment = session.get(Payment.class, id);
        if (payment != null) {
            session.delete(payment);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
