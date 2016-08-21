/*
 * JavaClassAsNativeDirectMethodCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 19:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectMethodCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeDirectMethodCallbackEnhancerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectMethodCallbackEnhancerRender extends JavaClassAsNativeDirectCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectMethodCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectMethodCallbackEnhancerRender(JavaClassAsNativeDirectMethodCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public MethodOfClassEnhancerRender getMethodOfClassEnhancerRender()
    {
        return (MethodOfClassEnhancerRender)behaviorEnhRender;
    }
    
    public String getRuntimeClassUtil()    
    {
        return NativeDirectMethodCallbackEnhancerImpl.class.getName();
    }    
    
}
