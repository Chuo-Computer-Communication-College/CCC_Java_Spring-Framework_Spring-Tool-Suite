package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/{month}")
    public ModelAndView index(ModelAndView mav, @PathVariable int month)
    {
        int intMonth = Math.abs(month) % 12;
        
        intMonth = intMonth == 0 ? 12 : intMonth;
        
        mav.addObject("month", intMonth);
        mav.addObject("check", Math.floor(intMonth / 3));
        
        mav.setViewName("index");
        
        return mav;
    }
}
