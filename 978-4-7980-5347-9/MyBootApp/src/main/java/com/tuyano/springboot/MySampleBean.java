package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MySampleBean
{
    private int intCounter = 0;
    private int intMax = 10;
    
    @Autowired
    public MySampleBean(ApplicationArguments aArguments)
    {
        List<String> lstFile = aArguments.getNonOptionArgs();
        
        try
        {
            intMax = Integer.parseInt(lstFile.get(0));
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
    
    public int count()
    {
        intCounter++;
        
        intCounter = intCounter > intMax ? 0 : intCounter;
        
        return intCounter;
    }
}
