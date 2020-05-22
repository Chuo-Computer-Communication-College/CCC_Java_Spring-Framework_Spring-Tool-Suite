package com.tuyano.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tuyano.springboot.repositories.MyDataRepository;

public class MyDataBean
{
    @Autowired
    MyDataRepository mdRepository;
    
    public String getTableTagById(Long id)
    {
        Optional<MyData> optMyData = mdRepository.findById(id);
        
        MyData md = optMyData.get();
        
        String strResult = 
                            "<tr>" + 
                                "<td>" + 
                                    md.getName() + 
                                "</td>" + 
                                "<td>" + 
                                    md.getMail() + 
                                "</td>" + 
                                "<td>" + 
                                    md.getAge() + 
                                "</td>" + 
                                "<td>" + 
                                    md.getMemo() + 
                                "</td>" + 
                            "</tr>";
        
        return strResult;
    }
}
