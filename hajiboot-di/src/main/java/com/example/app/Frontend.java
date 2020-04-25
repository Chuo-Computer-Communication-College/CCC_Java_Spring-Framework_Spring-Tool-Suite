package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Frontend
{
    @Autowired
    ArgumentResolver argument_resolver;

    @Autowired
    Calculator calculator;

    public void run()
    {
        System.out.print("Enter 2 numbers like 'a b': ");
        
        Argument arg = argument_resolver.resolve(System.in);
        
        int intResult = calculator.calculate(arg.getA(), arg.getB());
        
        System.out.print("Result = " + intResult);
    }
}
