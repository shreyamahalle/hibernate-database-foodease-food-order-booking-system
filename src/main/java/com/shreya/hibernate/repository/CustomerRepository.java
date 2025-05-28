package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.Customer;
import com.shreya.hibernate.repository.impl.CustomerRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerRepositoryImpl {

    private final Logger log = LoggerFactory.getLogger(CustomerRepository.class);

    @Override
    public void addCustomer(Customer customer) {
    }

    @Override
    public List<Customer> retrieveCustomers() {
        return List.of();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Customer deleteCustomer(int id) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updatePartialCustomer(Customer customer) {
        return null;
    }
}