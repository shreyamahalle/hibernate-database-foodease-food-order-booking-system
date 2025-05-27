package com.shreya.hibernate.service;

import com.shreya.hibernate.exception.CustomerNotFoundException;
import com.shreya.hibernate.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    String addCustomer(Customer customer) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    List<Customer> retrieveCustomers();

    Customer getCustomerById(int id) throws CustomerNotFoundException;

    boolean updatePartialCustomer(Customer customer) throws SQLException;

}
