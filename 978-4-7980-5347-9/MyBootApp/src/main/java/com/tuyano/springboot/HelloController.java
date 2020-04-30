package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav)
    {        
        mav.addObject("msg", "お名前を書いて送信してください。");
        
        mav.setViewName("index");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView send(@RequestParam("txtName") String name, ModelAndView mav)
    {
        mav.addObject("message", "こんにちは、" + name + "さん！");
        mav.addObject("name", name);
        
        mav.setViewName("index");
        
        return mav;
    }
}
