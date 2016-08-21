/*
 * InstanceMethodOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:41
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.InstanceMethodOfClassGen;


public class InstanceMethodOfClassGenRender extends MethodOfClassGenRender
{
    
    /**
     * Creates a new instance of InstanceMethodOfClassGenRender
     */
    public InstanceMethodOfClassGenRender(InstanceMethodOfClassGen accessObject)
    {
        super(accessObject);
    }
    
    public String getModifier()
    {
        return ""; 
    }  
    
    public String getThisClassDec()
    {
        return accessObject.getJavaClassAsMultipleFieldContainerGen().getFullName() + ".class,";
    }      
    
    public String getFinderMethodName()
    {
        return "findInstanceMethod";
    }
    
    public String getAddMethodClassName()
    {
        return "addCPPMethod";
    }        
}
