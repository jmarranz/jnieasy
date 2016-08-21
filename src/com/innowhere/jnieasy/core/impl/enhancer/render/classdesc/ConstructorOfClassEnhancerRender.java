/*
 * ConstructorOfClassEnhancerRender.java
 *
 * Created on 13 de octubre de 2004, 17:59
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.ConstructorOfClassEnhancer;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.NotFoundException;

public class ConstructorOfClassEnhancerRender extends BehaviorOfClassEnhancerRender
{
    
    /** Creates a new instance of ConstructorOfClassEnhancerRender */
    public ConstructorOfClassEnhancerRender(ConstructorOfClassEnhancer behaviorEnhancer)
    {
        super(behaviorEnhancer);
    }
    
    public ConstructorOfClassEnhancer getConstructorOfClassEnhancer()
    {
        return (ConstructorOfClassEnhancer)accessObjectEnh;
    }

    public String getAddMethodCallName()
    {
        return "addConstructor";
    }

    public String getMethodNameParam()
    {
        return "";
    }

    public void setDLLBasedBehaviorBody(String body)
    {    
        try
        {
            ConstructorOfClassEnhancer constrEnh = getConstructorOfClassEnhancer();
            CtConstructor ctConstr = constrEnh.getCtConstructor();
            ctConstr.setBody(body);
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
}
