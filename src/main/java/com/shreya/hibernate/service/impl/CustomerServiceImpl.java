package com.shreya.hibernate.service.impl;

import com.shreya.hibernate.exception.CustomerNotFoundException;
import com.shreya.hibernate.exception.CustomerServiceException;
import com.shreya.hibernate.model.Customer;
import com.shreya.hibernate.repository.CustomerRepository;
import com.shreya.hibernate.service.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;

    @Override
    public String addCustomer(Customer customer) {
        log.info("Saving Customer {}", customer);
        try {
            customerRepository.addCustomer(customer);
            return "Customer added successfully.";
        } catch (Exception e) {
            log.error("Error saving customer: {}", customer, e);
            throw new CustomerServiceException("Failed to add customer", e);
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        log.info("Deleting Customer with ID {}", id);
        try {
            boolean deleted = customerRepository.deleteCustomer(id);
            if (!deleted) {
                throw new CustomerNotFoundException("Customer not found with ID: " + id);
            }
            return true;
        } catch (Exception e) {
            log.error("Error deleting customer with ID {}", id, e);
            throw new CustomerServiceException("Failed to delete customer", e);
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        log.info("Updating Customer {}", customer);
        try {
            boolean updated = customerRepository.updateCustomer(customer);
            if (!updated) {
                throw new CustomerNotFoundException("Customer not found with ID: " + customer.getId());
            }
            return true;
        } catch (Exception e) {
            log.error("Error updating customer: {}", customer, e);
            throw new CustomerServiceException("Failed to update customer", e);
        }
    }

    @Override
    public List<Customer> retrieveCustomers() {
        log.info("Retrieving all customers");
        try {
            return customerRepository.retrieveCustomers();
        } catch (Exception e) {
            log.error("Error retrieving customers", e);
            throw new CustomerServiceException("Failed to retrieve customers", e);
        }
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        Optional<Customer> result;
        log.info("Fetching customer by ID: {}", id);
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            if (customer == null) {
                throw new CustomerNotFoundException("Customer not found with ID: " + id);
            }
            result = customer;
        } catch (Exception e) {
            log.error("Error fetching customer with ID {}", id, e);
            throw new CustomerServiceException("Failed to fetch customer", e);
        }
        return result;
    }

    @Override
    public boolean updatePartialCustomer(Customer customer) {
        log.info("Partially updating Customer: {}", customer);
        try {
            boolean updated = customerRepository.updatePartialCustomer(customer);
            if (!updated) {
                throw new CustomerNotFoundException("Customer not found with ID: " + customer.getId());
            }
            return true;
        } catch (Exception e) {
            log.error("Error in partial update for customer: {}", customer, e);
            throw new CustomerServiceException("Failed to partially update customer", e);
        }
    }
}
