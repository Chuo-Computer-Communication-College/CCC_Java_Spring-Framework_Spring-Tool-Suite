package com.tuyano.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.MyDataRepository;

@Controller
public class HelloController
{
    @Autowired
    MyDataRepository mdRepository;
    
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav)
    {
        Iterable<MyData> itrMyData = mdRepository.findAll();

        mav.addObject("message", "This is sample content.");
        mav.addObject("data", itrMyData);
        
        mav.setViewName("index");
        
        return mav;
    }
}
