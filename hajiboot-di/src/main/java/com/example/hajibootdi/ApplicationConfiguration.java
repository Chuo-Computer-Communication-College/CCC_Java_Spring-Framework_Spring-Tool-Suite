package com.example.hajibootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration
{
    @Bean
    Calculator calculator()
    {
        return new AdditionCalculator();
    }
    
    @Bean
    ArgumentResolver argument_resolver()
    {
        return new ScannerArgumentResolver();
    }
}
