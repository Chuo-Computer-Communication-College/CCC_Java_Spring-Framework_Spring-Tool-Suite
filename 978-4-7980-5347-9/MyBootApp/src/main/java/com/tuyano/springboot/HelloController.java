package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/{number}")
    public ModelAndView index(@PathVariable int number, ModelAndView mav)
    {
        int intResolution = 0;
        
        for (int i = 1; i <= number; i++)
        {
            intResolution += i;
        }
        
        mav.addObject("msg", "Total: " + intResolution);
        
        mav.setViewName("index");
        
        return mav;
    }
}
