package com.tuyano.springboot;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostConstruct
    public void init()
    {
        /* １つ目のダミーデータ作成 */
        MyData md1 = new MyData();
        
        md1.setName("Tuyano");
        md1.setAge(123);
        md1.setMail("shoda@tuyano.com");
        md1.setMemo("This is my data!");
        
        mdRepository.saveAndFlush(md1);

        /* ２つ目のダミーデータ作成 */
        MyData md2 = new MyData();
        
        md2.setName("Hanako");
        md2.setAge(15);
        md2.setMail("hanako@flower");
        md2.setMemo("This is my girl friend.");
        
        mdRepository.saveAndFlush(md2);

        /* ３つ目のダミーデータ作成 */
        MyData md3 = new MyData();
        
        md3.setName("Sachiko");
        md3.setAge(37);
        md3.setMail("sachiko@happy");
        md3.setMemo("This is my work friend...");
        
        mdRepository.saveAndFlush(md3);
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView mav, @ModelAttribute MyData md, @PathVariable int id)
    {
        Optional<MyData> optMyData = mdRepository.findById((long)id);

        mav.addObject("title", "Edit MyData.");
        mav.addObject("formModel", optMyData.get());
        
        mav.setViewName("edit");
        
        return mav;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView update(ModelAndView mav, @ModelAttribute MyData md)
    {
        mdRepository.saveAndFlush(md);
        
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(ModelAndView mav, @PathVariable int id)
    {
        Optional<MyData> optMyData = mdRepository.findById((long)id);

        mav.addObject("title", "Delete MyData.");
        mav.addObject("formModel", optMyData.get());
        
        mav.setViewName("delete");
        
        return mav;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView remove(ModelAndView mav, @RequestParam long id)
    {
        mdRepository.deleteById(id);
        
        return new ModelAndView("redirect:/");
    }
}
