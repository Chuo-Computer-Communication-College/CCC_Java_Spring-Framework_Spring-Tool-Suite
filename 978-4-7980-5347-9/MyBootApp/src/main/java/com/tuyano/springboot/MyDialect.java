package com.tuyano.springboot;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class MyDialect extends AbstractProcessorDialect
{
    private static final String DIALECT_NAME = "My Dialect";
    
    protected MyDialect(String name, String prefix, int processorPrecedence)
    {
        super(name, prefix, processorPrecedence);
    }
    
    public MyDialect()
    {
        super(DIALECT_NAME, "my", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix)
    {
        final Set<IProcessor> setProcessor = new HashSet<IProcessor>();
        
        setProcessor.add(new MyPageAttributeTagProcessor(dialectPrefix));
        
        return setProcessor;
    }

}
