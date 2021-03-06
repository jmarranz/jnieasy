/*
 * JavaClassAsFieldCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 18:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsFieldCallbackEnhancer extends JavaClassAsNativeDirectCallbackEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsFieldCallbackEnhancer
     */
    public JavaClassAsFieldCallbackEnhancer(JavaClassAsNativeDirectFieldCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);        
    }

    public JavaClassAsNativeDirectFieldCallbackImpl getJavaClassAsNativeDirectFieldCallback()
    {
        return (JavaClassAsNativeDirectFieldCallbackImpl)javaClass;
    }

}
