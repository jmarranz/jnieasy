/*
 * ConstructorOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:40
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.ConstructorOfClassGen;


public class ConstructorOfClassGenRender extends BehaviorOfClassGenRender
{
    
    /** Creates a new instance of ConstructorOfClassGenRender */
    public ConstructorOfClassGenRender(ConstructorOfClassGen accessObject)
    {
        super(accessObject);
    }

    public ConstructorOfClassGen getConstructorOfClassGen()
    {
        return (ConstructorOfClassGen)accessObject;
    }    
    
    public String getModifier()
    {
        return ""; 
    }    
    
    public String getHeaderReturnClassName()
    {
        return accessObject.getJavaClassAsMultipleFieldContainerGen().getSimpleName();
    }

    public String getMethodName()
    {
        return "";
    }
    
    public String getFinderMethodName()
    {
        return "findConstructor";
    }
    
    public String getAddMethodClassName()
    {
        return "addCPPConstructor";
    } 
    
    public String getReturnTypeClassExp()
    {
        return accessObject.getJavaClassAsMultipleFieldContainerGen().getFullName() + ".class,";
    }        
}
