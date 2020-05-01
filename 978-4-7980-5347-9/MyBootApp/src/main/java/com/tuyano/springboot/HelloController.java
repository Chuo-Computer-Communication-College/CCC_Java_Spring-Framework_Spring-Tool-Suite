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
        mav.addObject("message", "Message 1<hr/>Message 2<br/>Message 3");
        
        mav.setViewName("index");
        
        return mav;
    }
}
