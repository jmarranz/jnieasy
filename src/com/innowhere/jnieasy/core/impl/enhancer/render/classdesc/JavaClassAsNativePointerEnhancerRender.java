/*
 * JavaClassAsNativePointerEnhancerRender.java
 *
 * Created on 7 de febrero de 2005, 19:25
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativePointerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativePointerEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativePointerCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativePointerInternal;
import com.innowhere.jnieasy.core.typedec.NativePointerDescriptor;



public class JavaClassAsNativePointerEnhancerRender extends JavaClassAsNativeObjectFieldContainerEnhancerRender
{
    /**
     * Creates a new instance of JavaClassAsNativePointerEnhancerRender
     */
    public JavaClassAsNativePointerEnhancerRender(JavaClassAsNativePointerEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public JavaClassAsNativePointerEnhancer getJavaClassAsNativePointerEnhancer()
    {
        return (JavaClassAsNativePointerEnhancer)classEnhancer;
    }

    public String getInternalNativeInterfaceName()
    {
        return NativePointerInternal.class.getName();        
    }
    
    public String getNativeInterfaceName()
    {
        return NativePointer.class.getName();
    }      

    public String getDescriptorClassName()
    {
        return NativePointerDescriptor.class.getName();        
    }

    public String getInitRegistrationTypeCode()
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer();
        String pointerClassName = fieldEnh.getFieldCtClass().getName();

        int licenseUsedByEnhancer = classEnhancer.getCurrentLicenseUsedByEnhancer();
        
        return "(" + getDescriptorClassName() + ")" + NativePointerEnhancerImpl.class.getName() + ".initRegistrationPointerType(this,\"" + pointerClassName + "\"," + licenseUsedByEnhancer + ",jnieasyRoot); \n";
    }    

    public String getSuperClassName()
    {
        return NativePointerCustomImpl.class.getName();
    }
}
