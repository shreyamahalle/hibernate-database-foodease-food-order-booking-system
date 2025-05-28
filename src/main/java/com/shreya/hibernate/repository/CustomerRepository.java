package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository{

    void addCustomer(Customer customer);
    List<Customer> retrieveCustomers();
    Optional<Customer> findById(int id);
    Customer deleteCustomer(int id);
    Customer updateCustomer(Customer customer);
    Customer updatePartialCustomer(Customer customer);
}