/*
 * JavaClassAsUnionEnhancerRender.java
 *
 * Created on 1 de abril de 2004, 13:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsUnionEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.UnionEnhancerImpl;
import com.innowhere.jnieasy.core.typedec.UnionDescriptor;


public class JavaClassAsUnionEnhancerRender extends JavaClassAsNativeMultipleFieldContainerEnhancerRender
{
    /**
     * Creates a new instance of JavaClassAsUnionEnhancerRender 
     */
    public JavaClassAsUnionEnhancerRender(JavaClassAsUnionEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public JavaClassAsUnionEnhancer getJavaClassAsUnionEnhancer()
    {
        return (JavaClassAsUnionEnhancer)classEnhancer;
    }
   
    public String getNativeInterfaceName()
    {
        return Union.class.getName();
    }
    
    public String getDescriptorClassName()
    {
        return UnionDescriptor.class.getName();
    }    
    
    public JavaClassAsNativeCapableEnhancer enhanceSuperClass(EnhancerSourceFileContext ctx)
    {    
        // NO hay clase base
        return null; 
    }
    
    public String getInitRegistrationTypeCode()
    {
        JavaClassAsUnionEnhancer classEnhancer = getJavaClassAsUnionEnhancer();
        String desiredAlignSize = classEnhancer.getDesiredAlignSize();
        
        int licenseUsedByEnhancer = classEnhancer.getCurrentLicenseUsedByEnhancer();
        
        return "(" + getDescriptorClassName() + ")" + UnionEnhancerImpl.class.getName() + ".initRegistrationUnionType(this,\"" + desiredAlignSize + "\"," + licenseUsedByEnhancer + ",jnieasyRoot); \n";
    }    
}
