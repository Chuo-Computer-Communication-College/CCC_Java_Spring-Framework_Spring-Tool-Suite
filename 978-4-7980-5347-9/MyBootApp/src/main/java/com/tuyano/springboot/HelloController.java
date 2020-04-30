package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{    
    @RequestMapping("/{number}")
    public String index(@PathVariable int number, Model model)
    {
        int intResolution = 0;
        
        for (int i = 1; i <= number; i++)
        {
            intResolution += i;
        }
        
        model.addAttribute("msg", "Total: " + intResolution);
        
        return "index";
    }
}
