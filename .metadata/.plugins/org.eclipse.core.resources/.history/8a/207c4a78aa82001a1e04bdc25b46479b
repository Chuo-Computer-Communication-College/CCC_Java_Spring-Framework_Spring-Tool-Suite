package com.example.hajibootdi;

import java.util.Scanner;

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
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Enter 2 numbers like 'a b': ");

        int intA = scnr.nextInt();
        int intB = scnr.nextInt();
        
        Calculator calculator = ac.getBean(Calculator.class);
        
        int intResult = calculator.calculate(intA, intB);
        
        System.out.println("Result = " + intResult);
    }
}
