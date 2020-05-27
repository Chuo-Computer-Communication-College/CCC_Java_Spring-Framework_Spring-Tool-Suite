package com.tuyano.springboot;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

public class MyPageAttributeTagProcessor extends AbstractAttributeTagProcessor
{
    private static final int PRECEDENCE = 10000;
    
    private static final String ATTR_NAME = "mypage";
    
    public static int size = 2;

    protected MyPageAttributeTagProcessor(TemplateMode templateMode, String dialectPrefix, String elementName, boolean prefixElementName, String attributeName, boolean prefixAttributeName, int precedence, boolean removeAttribute)
    {
        super(templateMode, dialectPrefix, elementName, prefixElementName, attributeName, prefixAttributeName, precedence, removeAttribute);
    }
    
    public MyPageAttributeTagProcessor(final String dialectPrefix)
    {
        super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, true);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler)
    {
        final IEngineConfiguration eConfiguration = context.getConfiguration();
        
        final IStandardExpressionParser seParser = StandardExpressions.getExpressionParser(eConfiguration);
        
        final IStandardExpression sExpression = seParser.parseExpression(context, attributeValue);
        
        int intValue = (int)sExpression.execute(context);
        
        intValue = intValue < 0 ? 0 : intValue;
        
        structureHandler.setAttribute("href", "/page?size=" + size + "&page=" + intValue);
    }
}
