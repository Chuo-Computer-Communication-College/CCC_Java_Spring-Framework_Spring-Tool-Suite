package com.tuyano.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBootAppConfig
{
    @Bean
    MyDataBean beanMyData()
    {
        return new MyDataBean();
    }
}
