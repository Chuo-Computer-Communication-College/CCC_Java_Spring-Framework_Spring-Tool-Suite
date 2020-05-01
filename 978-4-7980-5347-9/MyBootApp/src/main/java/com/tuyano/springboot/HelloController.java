package com.tuyano.springboot;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav)
    {
        ArrayList<String[]> alData = new ArrayList<String[]>();

        alData.add(new String[]{"Taro", "taro@yamada", "090-999-999"});
        alData.add(new String[]{"Hanako", "hanako@flower", "080-888-888"});
        alData.add(new String[]{"Sachiko", "sachiko@happy", "070-777-777"});
        
        mav.addObject("data", alData);
        
        mav.setViewName("index");
        
        return mav;
    }
}
