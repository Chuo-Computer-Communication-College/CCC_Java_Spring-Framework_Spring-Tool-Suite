package com.example.hajibootdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import(ApplicationConfiguration.class)
public class HajibootDiApplication
{
    public static void main(String[] args)
    {
        ApplicationContext ac = SpringApplication.run(HajibootDiApplication.class, args);
        
        System.out.print("Enter 2 numbers like 'a b': ");
        
        ArgumentResolver ar = ac.getBean(ArgumentResolver.class);
        
        Argument argmnt = ar.resolve(System.in);
        
        Calculator cltr = ac.getBean(Calculator.class);
        
        int intResult = cltr.calculate(argmnt.getA(), argmnt.getB());
        
        System.out.println("Result = " + intResult);
    }
}
