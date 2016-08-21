/*
 * JavaClassAsNativeDirectFieldCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 19:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsFieldCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeDirectFieldCallbackEnhancerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectFieldCallbackEnhancerRender extends JavaClassAsNativeDirectCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectFieldCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectFieldCallbackEnhancerRender(JavaClassAsFieldCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }    
    
    public String getRuntimeClassUtil()    
    {
        return NativeDirectFieldCallbackEnhancerImpl.class.getName();
    }    
        
    public FieldMethodOfClassEnhancerRender getFieldMethodOfClassEnhancerRender()
    {
        return (FieldMethodOfClassEnhancerRender)behaviorEnhRender;
    }    
}
