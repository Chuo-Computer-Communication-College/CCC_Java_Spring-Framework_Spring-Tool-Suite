package com.tuyano.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.MyDataMongoRepository;

@Controller
public class HelloController
{
    @Autowired
    MyDataMongoRepository mdmRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav)
    {
        Iterable<MyDataMongo> iteMyDataMongo = mdmRepository.findAll();
        
        mav.addObject("title", "Find Page");
        mav.addObject("message", "MyDataMongoのサンプルです。");
        mav.addObject("dataList", iteMyDataMongo);
        
        mav.setViewName("index");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@RequestParam("name") String name, @RequestParam("memo") String memo, ModelAndView mav)
    {
        MyDataMongo mdMongo = new MyDataMongo(name, memo);
        
        mdmRepository.save(mdMongo);
        
        return new ModelAndView("redirect:/");
    }
}
