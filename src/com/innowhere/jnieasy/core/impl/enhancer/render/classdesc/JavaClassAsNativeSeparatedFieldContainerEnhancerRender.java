/*
 * JavaClassAsNativeSeparatedFieldContainerEnhancerRender.java
 *
 * Created on 13 de octubre de 2005, 19:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeSeparatedFieldContainerEnhancer;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeSeparatedFieldContainerEnhancerRender extends JavaClassAsNativeMultipleFieldContainerEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeSeparatedFieldContainerEnhancerRender
     */
    public JavaClassAsNativeSeparatedFieldContainerEnhancerRender(JavaClassAsNativeSeparatedFieldContainerEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public JavaClassAsNativeSeparatedFieldContainerEnhancer getJavaClassAsSeparatedFieldContainerEnhancer()
    {
        return (JavaClassAsNativeSeparatedFieldContainerEnhancer)classEnhancer;
    }
    
    public JavaClassAsNativeCapableEnhancer enhanceSuperClass(EnhancerSourceFileContext ctx)
    {
        JavaClassAsNativeSeparatedFieldContainerEnhancer classEnhancer = getJavaClassAsSeparatedFieldContainerEnhancer();        
        JavaClassAsNativeSeparatedFieldContainerEnhancer superClassEnhancer = classEnhancer.getSuperClass();
        if (superClassEnhancer != null)
            JavaClassAsNativeCapableEnhancerRender.enhance(superClassEnhancer,ctx);

        return superClassEnhancer;
    }    
    
    public String getInitRegistrationTypeCode()
    {
        JavaClassAsNativeSeparatedFieldContainerEnhancer classEnhancer = getJavaClassAsSeparatedFieldContainerEnhancer();        
        JavaClassAsNativeSeparatedFieldContainerEnhancer superClassEnhancer = classEnhancer.getSuperClass();
        String superClassName = null;
        if (superClassEnhancer != null)
            superClassName = "\"" + superClassEnhancer.getName() + "\"";
        String desiredAlignSize = classEnhancer.getDesiredAlignSize();        
        
        int licenseUsedByEnhancer = classEnhancer.getCurrentLicenseUsedByEnhancer();
        
        return "(" + getDescriptorClassName() + ")" + getRegisterClassTypeCall() + "(this," + superClassName + ",\"" + desiredAlignSize + "\"," + licenseUsedByEnhancer + ",jnieasyRoot); \n";            
    }    
       
    public abstract String getRegisterClassTypeCall();    
}
