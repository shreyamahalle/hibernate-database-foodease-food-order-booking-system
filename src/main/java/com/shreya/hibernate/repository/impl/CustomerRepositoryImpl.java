package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Customer;
import com.shreya.hibernate.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory sessionFactory;

    private CustomerRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Customer> retrieveCustomers() {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }

    @Override
    public Optional<Customer> findById(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return Optional.ofNullable(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer toDelete = session.load(Customer.class, id);
        session.delete(toDelete);
        session.getTransaction().commit();
        session.flush();
        session.close();
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer existing = session.get(Customer.class, customer.getId());
        if (existing != null) {
            session.merge(customer);
            session.getTransaction().commit();
            session.flush();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updatePartialCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer existing = session.get(Customer.class, customer.getId());
        if (existing != null) {
            if (customer.getName() != null) existing.setName(customer.getName());
            if (customer.getCity() != null) existing.setCity(customer.getCity());
            if (customer.getMobileNo() != 0) existing.setMobileNo(customer.getMobileNo());
            if (customer.getAge() != 0) existing.setAge(customer.getAge());

            session.update(existing);
            session.getTransaction().commit();
            session.flush();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
