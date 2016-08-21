/*
 * StaticMethodOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:42
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.StaticMethodOfClassGen;


public class StaticMethodOfClassGenRender extends MethodOfClassGenRender
{
    
    /** Creates a new instance of StaticMethodOfClassGenRender */
    public StaticMethodOfClassGenRender(StaticMethodOfClassGen accessObject)
    {
        super(accessObject);
    }

    public String getModifier()
    {
        return "static"; 
    }
    
    public String getFinderMethodName()
    {
        return "findStaticMethod";
    }
    
    public String getAddMethodClassName()
    {
        return "addCMethod";
    }     
       
}
