package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.Customer;
import net.javaguides.springboot.repository.CustomerRepository;
import net.javaguides.springboot.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService
{

private CustomerRepository customerRepository;
    

    public CustomerServiceImp(CustomerRepository customerRepository)
    {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        // TODO Auto-generated method stub
        return customerRepository.findAll();
    }



    @Override
    public Customer saveCustomer(Customer customer)
    {
        // TODO Auto-generated method stub
        return customerRepository.save(customer);
    }



    @Override
    public Customer getCustomerById(Long id)
    {
        // TODO Auto-generated method stub
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer)
    {
        // TODO Auto-generated method stub
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id)
    {
        customerRepository.deleteById(id);
        
    }


  

}
