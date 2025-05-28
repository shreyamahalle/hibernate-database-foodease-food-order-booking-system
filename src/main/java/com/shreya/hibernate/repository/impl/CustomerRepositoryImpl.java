package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Customer;
import com.shreya.hibernate.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

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