package com.tuyano.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(MyBootApp.class, new String[]{"100"});
    }
}
