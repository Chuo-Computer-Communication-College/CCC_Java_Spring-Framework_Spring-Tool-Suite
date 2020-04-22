package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner
{
    @Autowired
    NamedParameterJdbcTemplate npTemplate;
    
    public static void main(String[] args)
    {
        SpringApplication.run(HajibootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        String strSQL = 
                        "Select " + 
                            "1 " + 
                        ";";
        
        SqlParameterSource pSource = new MapSqlParameterSource();
        
        Integer intResult = npTemplate.queryForObject(strSQL, pSource, Integer.class);
        
        System.out.println("Result = " + intResult);
    }
}
