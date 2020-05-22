package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyDataRestController
{
    @Autowired
    private MyDataService mdService;
    
    @Autowired
    MySampleBean msBean;
    
    @RequestMapping("/count")
    public int count()
    {
        return msBean.count();
    }
    
    @RequestMapping("/rest")
    public List<MyData> restAll()
    {
        return mdService.getAll();
    }
    
    @RequestMapping("/rest/{number}")
    public MyData restBy(@PathVariable int number)
    {
        return mdService.get(number);
    }
}
