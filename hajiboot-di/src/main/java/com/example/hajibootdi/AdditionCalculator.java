package com.example.hajibootdi;

import org.springframework.stereotype.Component;

@Component
public class AdditionCalculator implements Calculator
{
    @Override
    public int calculate(int a, int b)
    {
        return a + b;
    }
}
