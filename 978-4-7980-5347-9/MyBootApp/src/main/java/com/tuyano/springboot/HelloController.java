package com.tuyano.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    String[] name_a = 
                        {
                            "tuyano", 
                            "hanako", 
                            "taro", 
                            "sachiko", 
                            "ichiro"
                        };

    String[] mail_a = 
                        {
                            "shoda@tuuyano.com", 
                            "hanako@flower", 
                            "taro@yamada", 
                            "sachiko@happy", 
                            "ichiro@baseball"
                        };
    
    @RequestMapping("/{id}")
    public DataObject index(@PathVariable int id)
    {        
        return new DataObject(id, name_a[id], mail_a[id]);
    }
}
