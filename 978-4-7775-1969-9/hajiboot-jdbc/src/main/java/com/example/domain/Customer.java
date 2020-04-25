package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer
{
    private Integer id;

    private String firstName;
    private String lastName;
}
