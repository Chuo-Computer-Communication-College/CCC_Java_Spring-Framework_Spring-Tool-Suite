package com.example.hajibootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration
{
    @Bean
    ArgumentResolver argument_resolver()
    {
        return new ScannerArgumentResolver();
    }
    
    @Bean
    Calculator calculator()
    {
        return new AdditionCalculator();
    }
    
    @Bean
    Frontend frontend()
    {
        return new Frontend();
    }
}
