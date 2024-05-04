package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.entity.Customer;
import net.javaguides.springboot.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImpTest {

    @Mock
    CustomerRepository customerRepository;
    Customer testCustomer1;
    Customer testCustomer2;


    @InjectMocks
    CustomerServiceImp service;


    @BeforeEach
    void setUp() {
        testCustomer1 = new Customer(123L, "John", "Smith", "john.smith@hotmail.com","2145551234");
        testCustomer2 = new Customer(124L, "Jane", "Smith", "jane.smith@hotmail.com","2145551235");
    }

    @Test
    void getAllCustomers() {
        when(customerRepository.findAll()).thenReturn(new ArrayList<>(List.of(testCustomer1, testCustomer2)));
        List<Customer> customerList = service.getAllCustomers();
        assert(customerList.contains(testCustomer1));
        assert(customerList.contains(testCustomer2));
        assert(customerList.size() == 2);
    }

    @Test
    void saveCustomer() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomerById() {
    }


}