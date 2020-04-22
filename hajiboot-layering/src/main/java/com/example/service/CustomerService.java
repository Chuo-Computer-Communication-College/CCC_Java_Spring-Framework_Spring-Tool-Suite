package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepository customer_repository;
    
    public Customer save(Customer customer)
    {
        return customer_repository.save(customer);
    }
    
    public List<Customer> findAll()
    {
        return customer_repository.findAll();
    }
}
