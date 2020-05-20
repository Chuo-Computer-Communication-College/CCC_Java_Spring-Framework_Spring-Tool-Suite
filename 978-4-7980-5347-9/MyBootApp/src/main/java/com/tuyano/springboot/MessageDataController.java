package com.tuyano.springboot;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.MessageDataRepository;

@Controller
public class MessageDataController
{
    @PersistenceContext
    EntityManager eManager;
    
    MessageDataDaoImpl mdDAO;
    
    @Autowired
    MessageDataRepository mdRepository;
    
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView message(ModelAndView mav)
    {
        MessageData md = new MessageData();
        
        List<MessageData> lstMessageData = (List<MessageData>)mdDAO.getAll();
        
        mav.addObject("title", "Sample");
        mav.addObject("message", "MessageDataのサンプルです。");
        mav.addObject("formModel", md);
        mav.addObject("dataList", lstMessageData);
        
        mav.setViewName("message_data_show");
        
        return mav;
    }
    
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ModelAndView messageForm(@ModelAttribute @Valid MessageData md, Errors err, ModelAndView mav)
    {
        if (err.hasErrors())
        {
            mav.addObject("title", "Sample [Error]");
            mav.addObject("message", "値を再チェックしてください。");
            
            mav.setViewName("message_data_show");
            
            return mav;
        }
        else
        {
            mdRepository.saveAndFlush(md);
            
            return new ModelAndView("redirect:/message");
        }
    }
    
    @PostConstruct
    public void initialize()
    {
        System.out.println("OK.");
        
        mdDAO = new MessageDataDaoImpl(eManager);
    }
}
