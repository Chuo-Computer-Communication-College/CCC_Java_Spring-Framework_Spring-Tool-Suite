package com.example.hajibootdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class HajibootDiApplication
{
    public static void main(String[] args)
    {
        ApplicationContext ac = SpringApplication.run(HajibootDiApplication.class, args);
        
        Frontend fe = ac.getBean(Frontend.class);
        
        fe.run();
    }
}
