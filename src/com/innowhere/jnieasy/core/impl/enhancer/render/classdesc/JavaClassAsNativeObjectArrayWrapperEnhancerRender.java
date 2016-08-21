/*
 * ClassArrayEnhancer.java
 *
 * Created on 25 de marzo de 2004, 18:23
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */

import javassist.*;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.NativeObjectArrayDescriptor;


public abstract class JavaClassAsNativeObjectArrayWrapperEnhancerRender extends JavaClassAsNativeObjectFieldContainerEnhancerRender
{
   
    /** Creates a new instance of ClassArrayEnhancer */
    public JavaClassAsNativeObjectArrayWrapperEnhancerRender(JavaClassAsNativeObjectArrayWrapperEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public JavaClassAsNativeObjectArrayWrapperEnhancer getJavaClassAsNativeObjectArrayWrapperEnhancer()
    {
        return (JavaClassAsNativeObjectArrayWrapperEnhancer)classEnhancer;
    }
  
    public String getInitRegistrationTypeCode()
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer();
        CtClass fieldType = fieldEnh.getFieldCtClass();
        String arrayClassName = fieldType.getName();

        int licenseUsedByEnhancer = classEnhancer.getCurrentLicenseUsedByEnhancer();
        
        return "(" + getDescriptorClassName() + ")" + NativeObjectArrayEnhancerImpl.class.getName() + ".initRegistrationObjectArrayType(this,\"" + arrayClassName + "\"," + licenseUsedByEnhancer + ",jnieasyRoot); \n";
    }    
    
    public String getInternalNativeInterfaceName()
    {
        return CanBeNativeCapableInternal.class.getName();        
    }
    
    public String getDescriptorClassName()
    {
        return NativeObjectArrayDescriptor.class.getName();
    }   

}
