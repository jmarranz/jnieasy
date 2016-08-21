/*
 * StaticFieldMethodOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:42
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.StaticFieldMethodOfClassGen;
import com.innowhere.jnieasy.core.method.*;


public class StaticFieldMethodOfClassGenRender extends FieldMethodOfClassGenRender
{
    
    /**
     * Creates a new instance of StaticFieldMethodOfClassGenRender
     */
    public StaticFieldMethodOfClassGenRender(StaticFieldMethodOfClassGen accessObject)
    {
        super(accessObject);
    }
  
    public String getModifier()
    {
        return "static"; 
    }
    
    public String getFinderMethodName()
    {
        return "findStaticField";
    }
    
    public String getAddMethodClassName()
    {
        return "addCFieldMethod";
    }     

}
