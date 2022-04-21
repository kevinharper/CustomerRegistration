package net.javaguides.springboot.service;

import java.util.*;

import net.javaguides.springboot.entity.Customer;


public interface CustomerService
{
    List<Customer> getAllCustomers();
    
    Customer saveCustomer(Customer customer);
    
    Customer getCustomerById(Long id);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
}
