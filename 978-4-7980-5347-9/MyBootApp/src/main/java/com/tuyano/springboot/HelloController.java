package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/{tax}")
    public ModelAndView index(ModelAndView mav, @PathVariable int tax)
    {        
        mav.addObject("tax", tax);
        
        mav.setViewName("index");
        
        return mav;
    }
}
