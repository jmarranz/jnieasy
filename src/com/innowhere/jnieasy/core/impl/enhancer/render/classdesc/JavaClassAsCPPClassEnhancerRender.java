/*
 * JavaClassAsCPPClassEnhancerRender.java
 *
 * Created on 1 de abril de 2004, 13:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsCPPClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.CPPClassEnhancerImpl;
import com.innowhere.jnieasy.core.typedec.CPPClassDescriptor;


public class JavaClassAsCPPClassEnhancerRender extends JavaClassAsNativeSeparatedFieldContainerEnhancerRender
{
    /**
     * Creates a new instance of JavaClassAsCPPClassEnhancerRender 
     */
    public JavaClassAsCPPClassEnhancerRender(JavaClassAsCPPClassEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public JavaClassAsCPPClassEnhancer getJavaClassAsCPPClassEnhancer()
    {
        return (JavaClassAsCPPClassEnhancer)classEnhancer;
    }
   
    public String getNativeInterfaceName()
    {
        return CPPClass.class.getName();
    }
    
    public String getDescriptorClassName()
    {
        return CPPClassDescriptor.class.getName();
    }    
    
    public String getRegisterClassTypeCall()    
    {
        return CPPClassEnhancerImpl.class.getName() + ".initRegistrationCPPClassType";
    }    
}
