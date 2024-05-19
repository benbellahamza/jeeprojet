package org.sid.projectue.services;

import org.sid.projectue.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    void deleteAllCustomers();
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();

    Page<Customer> getAllCustomersByPage(int page, int size);
}