package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.Customer;

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
                        "SELECT " + 
                            "id, " + 
                            "first_name, " + 
                            "last_name " + 
                        "FROM " + 
                            "customers " + 
                        "WHERE " + 
                            "id = :id " + 
                        ";";

        SqlParameterSource pSource = new MapSqlParameterSource().addValue("id", 1);
        
//        SqlParameterSource pSource = new MapSqlParameterSource();
//        
//        ((MapSqlParameterSource)pSource).addValue("id", 1);
        
        Customer cstmrResult = npTemplate.queryForObject
        (
            strSQL, 
            pSource, 
            (rSet, RowNumber) -> 
                new Customer(rSet.getInt("id"), rSet.getString("first_name"), rSet.getString("last_name"))
        );
        
        System.out.println("Result = " + cstmrResult);
    }
}
