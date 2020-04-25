package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;

@SpringBootApplication
public class HajibootDiApplication implements CommandLineRunner
{
    @Autowired
    ArgumentResolver argument_resolver;

    @Autowired
    Calculator calculator;
    
    public static void main(String[] args)
    {
        ApplicationContext ac = SpringApplication.run(HajibootDiApplication.class, args);
        
        Frontend fe = ac.getBean(Frontend.class);
        
        fe.run();
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.print("Enter 2 numbers like 'a b': ");
        
        Argument arg = argument_resolver.resolve(System.in);
        
        int intResult = calculator.calculate(arg.getA(), arg.getB());
        
        System.out.print("Result = " + intResult);        
    }
}
