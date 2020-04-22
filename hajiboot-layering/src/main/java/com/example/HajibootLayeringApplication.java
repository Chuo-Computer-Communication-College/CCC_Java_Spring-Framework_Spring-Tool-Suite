package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@SpringBootApplication
public class HajibootLayeringApplication implements CommandLineRunner
{
    @Autowired
    CustomerService customer_service;
    
    public static void main(String[] args)
    {
        SpringApplication.run(HajibootLayeringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        /* データ追加 */
        customer_service.save(new Customer(1, "Nobita", "Nobi"));
        customer_service.save(new Customer(2, "Takeshi", "Goda"));
        customer_service.save(new Customer(3, "Suneo", "Honekawa"));
        
        /* データ表示 */
        customer_service.findAll().forEach(System.out::println);
    }
}
