package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/{id}")
    public ModelAndView index(ModelAndView mav, @PathVariable int id)
    {
        mav.addObject("id", id);
        mav.addObject("check", id >= 0);
        mav.addObject("true_val", "Positive!");
        mav.addObject("false_val", "Negative...");
        
        mav.setViewName("index");
        
        return mav;
    }
}
