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
        mav.addObject("message", "フォームを送信ください。");
        
        mav.setViewName("index");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView send(
            @RequestParam(value = "cb", required = false) boolean chkBox,
            @RequestParam(value = "rdSex", required = false) String rdSex,
            @RequestParam(value = "slcOS", required = false) String slcOS,
            @RequestParam(value = "slcMOS", required = false) String[] slcMOS, 
            ModelAndView mav)
    {
        String strResolution = "";
        
        try
        {
            strResolution = 
                    "chkBox: " + chkBox + System.getProperty("line.separator") + 
                    "rdSex: " + rdSex + System.getProperty("line.separator") + 
                    "slcOS: " + slcOS + System.getProperty("line.separator") + 
                    "slcMOS: ";
            
            if (slcMOS == null)
            {
                strResolution += "Null";
            }
            else
            {                
                for (int i = 0; i < slcMOS.length; i++)
                {
                    strResolution += slcMOS[i];
                    
                    if (i < slcMOS.length - 1)
                    {
                        strResolution += ", ";
                    }
                }
            }
        }
        catch (NullPointerException e)
        {
            // TODO: handle exception
        }
        
        mav.addObject("message", strResolution);
        
        mav.setViewName("index");
        
        return mav;
    }
}
