package com.tuyano.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.MyDataRepository;

@Controller
public class HelloController
{
    @Autowired
    MyDataRepository mdRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav, @ModelAttribute("formModel") MyData md)
    {
        Iterable<MyData> itrMyData = mdRepository.findAll();

        mav.addObject("Message", "This is sample content.");
        mav.addObject("DataList", itrMyData);
        
        mav.setViewName("index");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(ModelAndView mav, @ModelAttribute("formModel") MyData md)
    {
        mdRepository.saveAndFlush(md);
        
        return new ModelAndView("redirect:/");
    }
}
