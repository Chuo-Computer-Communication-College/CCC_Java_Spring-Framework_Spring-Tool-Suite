package com.tuyano.springboot;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping("/{number}")
    public ModelAndView index(ModelAndView mav, @PathVariable int number)
    {
        ArrayList<DataObject> alData = new ArrayList<DataObject>();

        alData.add(new DataObject(0, "Taro", "taro@yamada"));
        alData.add(new DataObject(1, "Hanako", "hanako@flower"));
        alData.add(new DataObject(2, "Sachiko", "sachiko@happy"));
        
        mav.addObject("data", alData);
        
        if (number >= 0)
        {
            mav.addObject("check", "number >= data.size() ? 0 : number");
        }
        else
        {
            mav.addObject("check", "number <= data.size() * -1 ? 0 : number * -1");
        }
        
        mav.setViewName("index");
        
        return mav;
    }
}
