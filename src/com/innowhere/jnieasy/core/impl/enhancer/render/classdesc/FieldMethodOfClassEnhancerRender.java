/*
 * MethodOfClassEnhancer.java
 *
 * Created on 13 de octubre de 2004, 17:57
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldMethodOfClassEnhancer;

/**
 *
 * @author  jmarranz
 */



public class FieldMethodOfClassEnhancerRender extends BehaviorOfClassEnhancerRender
{
    /** Creates a new instance of MethodOfClassEnhancer */
    public FieldMethodOfClassEnhancerRender(FieldMethodOfClassEnhancer methodEnhancer)
    {
        super(methodEnhancer);
    }
    
    public FieldMethodOfClassEnhancer getFieldMethodOfClassEnhancer()
    {
        return (FieldMethodOfClassEnhancer)accessObjectEnh;
    }
    
    public String getAddMethodCallName()
    {
        return "addFieldMethod";
    }
    
    public String getMethodNameParam()
    {
        FieldMethodOfClassEnhancer methodEnh = getFieldMethodOfClassEnhancer();
        return ", \"" + methodEnh.getFieldMethodOfClass().getName() + "\"";
    }

    public void setDLLBasedBehaviorBody(String body)
    {    
        throw new JNIEasyException("INTERNAL ERROR");
    }

}

