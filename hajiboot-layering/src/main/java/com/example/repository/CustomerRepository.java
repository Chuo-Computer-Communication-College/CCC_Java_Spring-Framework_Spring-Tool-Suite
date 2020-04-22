package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.example.domain.Customer;

@Repository
public class CustomerRepository
{
    private final ConcurrentMap<Integer, Customer> chMap = new ConcurrentHashMap<>();
    
    public List<Customer> findAll()
    {
        return new ArrayList<>(chMap.values());
    }
    
    public Customer findOne(Integer CustomerId)
    {
        return chMap.get(CustomerId);
    }
    
    public Customer save(Customer customer)
    {
        return chMap.put(customer.getId(), customer);
    }
    
    public void delete(Integer CustomerId)
    {
        chMap.remove(CustomerId);
    }
}
