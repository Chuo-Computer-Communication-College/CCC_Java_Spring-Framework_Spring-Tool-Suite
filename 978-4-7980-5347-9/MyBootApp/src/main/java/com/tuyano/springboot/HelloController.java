package com.tuyano.springboot;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    MyDataDaoImpl mdDAO;
    
    @Autowired
    MyDataRepository mdRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav)
    {
        Iterable<MyData> iteMyData = mdRepository.findAllOrderByName();

        mav.addObject("title", "Find Page");
        mav.addObject("message", "MyDataのサンプルです。");
        mav.addObject("dataList", iteMyData);
        
        mav.setViewName("index");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") @Validated MyData md, BindingResult bResult, ModelAndView mav)
    {
        ModelAndView mavResolution = null;
        
        if (bResult.hasErrors())
        {
            Iterable<MyData> iteMyData = mdRepository.findAll();

            mav.addObject("message", "Sorry, error is occured...");
            mav.addObject("dataList", iteMyData);
            
            mav.setViewName("index");
            
            mavResolution = mav;
        }
        else
        {
            mdRepository.saveAndFlush(md);
            
            mavResolution = new ModelAndView("redirect:/");
        }
        
        return mavResolution;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData md, @PathVariable int id, ModelAndView mav)
    {
        Optional<MyData> optMyData = mdRepository.findById((long)id);

        mav.addObject("title", "Edit MyData.");
        mav.addObject("formModel", optMyData.get());
        
        mav.setViewName("edit");
        
        return mav;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView update(@ModelAttribute MyData md, ModelAndView mav)
    {
        mdRepository.saveAndFlush(md);
        
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, ModelAndView mav)
    {
        Optional<MyData> optMyData = mdRepository.findById((long)id);

        mav.addObject("title", "Delete MyData.");
        mav.addObject("formModel", optMyData.get());
        
        mav.setViewName("delete");
        
        return mav;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView remove(@RequestParam long id, ModelAndView mav)
    {
        mdRepository.deleteById(id);
        
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView find(ModelAndView mav)
    {
        Iterable<MyData> iteMyData = mdDAO.getAll();
        
        mav.addObject("title", "Find Page");
        mav.addObject("message", "MyDataのサンプルです。");
        mav.addObject("value", "");
        mav.addObject("dataList", iteMyData);
        
        mav.setViewName("find");
        
        return mav;
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest sRequest, ModelAndView mav)
    {
        String strParam = sRequest.getParameter("fstr");
        
        if (strParam == "")
        {
            mav = new ModelAndView("redirect:/find");
        }
        else
        {
            Iterable<MyData> iteMyData = mdDAO.find(strParam);
            
            mav.addObject("title", "Find Result");
            mav.addObject("message", "「" + strParam + "」の検索結果");
            mav.addObject("value", strParam);
            mav.addObject("dataList", iteMyData);
        }
        
        mav.setViewName("find");
        
        return mav;
    }
    
    @PostConstruct
    public void initialize()
    {
        /* １つ目のダミーデータ作成 */
        MyData md1 = new MyData();
        
        md1.setName("Tuyano");
        md1.setAge(123);
        md1.setMail("shoda@tuyano.com");
        md1.setMemo("090999999");
        
        mdRepository.saveAndFlush(md1);

        /* ２つ目のダミーデータ作成 */
        MyData md2 = new MyData();
        
        md2.setName("Hanako");
        md2.setAge(15);
        md2.setMail("hanako@flower");
        md2.setMemo("080888888");
        
        mdRepository.saveAndFlush(md2);

        /* ３つ目のダミーデータ作成 */
        MyData md3 = new MyData();
        
        md3.setName("Sachiko");
        md3.setAge(37);
        md3.setMail("sachiko@happy");
        md3.setMemo("070777777");
        
        mdRepository.saveAndFlush(md3);
    }
}
