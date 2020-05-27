package com.tuyano.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class MyBootAppConfig
{
    @Bean
    public ClassLoaderTemplateResolver resolveClassLoaderTemplate()
    {
        ClassLoaderTemplateResolver cltResolver = new ClassLoaderTemplateResolver();
        
        cltResolver.setCacheable(false);
        cltResolver.setCharacterEncoding("UTF-8");
        cltResolver.setPrefix("templates/");
        cltResolver.setSuffix(".html");
        cltResolver.setTemplateMode("HTML5");
        
        return cltResolver;
    }
    
    @Bean
    public SpringTemplateEngine engineSpringTemplate()
    {
        SpringTemplateEngine stEngine = new SpringTemplateEngine();
        
        stEngine.addDialect(new MyDialect());
        stEngine.setTemplateResolver(resolveClassLoaderTemplate());
        
        return stEngine;
    }
    
    @Bean
    MyDataBean beanMyData()
    {
        return new MyDataBean();
    }
}
