package com.tuyano.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/{Number}")
    public String index(@PathVariable int Number)
    {
        int intResolution = 0;
        
        for (int i = 1; i <= Number; i++)
        {
            intResolution += i;
        }
        
        return "Total: " + intResolution;
    }
}
