/*
 * MethodOfClassEnhancer.java
 *
 * Created on 13 de octubre de 2004, 17:57
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.MethodOfClassEnhancer;

import javassist.CannotCompileException;
import javassist.CtMethod;
import javassist.Modifier;

/**
 *
 * @author  jmarranz
 */



public class MethodOfClassEnhancerRender extends BehaviorOfClassEnhancerRender
{
    /** Creates a new instance of MethodOfClassEnhancer */
    public MethodOfClassEnhancerRender(MethodOfClassEnhancer methodEnhancer)
    {
        super(methodEnhancer);
    }
    
    public MethodOfClassEnhancer getMethodOfClassEnhancer()
    {
        return (MethodOfClassEnhancer)accessObjectEnh;
    }
    
    public String getAddMethodCallName()
    {
        return "addMethod";
    }
    
    public String getMethodNameParam()
    {
        MethodOfClassEnhancer methodEnh = getMethodOfClassEnhancer();
        String name = methodEnh.getMethodOfClass().getName();
        return ", \"" + name + "\"";
    }

    public void setDLLBasedBehaviorBody(String body)
    {    
        try
        {
            MethodOfClassEnhancer methodEnh = getMethodOfClassEnhancer();            
            CtMethod ctMethod = methodEnh.getCtMethod(); 
            // Eliminamos el posible atributo NATIVE pues ahora el método tiene body.
            int mod = ctMethod.getModifiers();
            if (Modifier.isNative(mod))
            {
                mod = Modifier.clear(mod,Modifier.NATIVE);
                ctMethod.setModifiers(mod);
            }
            ctMethod.setBody(body);
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }
    }

}

