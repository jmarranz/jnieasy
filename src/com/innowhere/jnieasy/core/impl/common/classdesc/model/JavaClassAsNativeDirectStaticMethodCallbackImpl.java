/*
 * JavaClassAsNativeDirectStaticMethodCallbackImpl.java
 *
 * Created on 7 de julio de 2005, 18:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectStaticMethodCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticMethodCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticMethodCallbackImpl extends JavaClassAsNativeDirectMethodCallbackImpl
{
    
    /** Creates a new instance of JavaClassAsNativeDirectStaticMethodCallbackImpl */
    public JavaClassAsNativeDirectStaticMethodCallbackImpl(ClassTypeNativeDirectStaticMethodCallbackCustomImpl classType)
    {
        super(classType);
    }

    public JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(EnhancerSharedContext ctx)
    {
        return new JavaClassAsNativeDirectStaticMethodCallbackEnhancer(this,ctx);
    }
    
}
