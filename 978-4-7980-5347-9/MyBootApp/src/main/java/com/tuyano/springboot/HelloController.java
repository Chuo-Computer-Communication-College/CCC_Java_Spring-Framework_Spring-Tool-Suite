package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav)
    {
        DataObject dObject = new DataObject(123, "Hanako", "hanako@flower");

        mav.addObject("message", "Current Data");
        mav.addObject("object", dObject);
        
        mav.setViewName("index");
        
        return mav;
    }
}
