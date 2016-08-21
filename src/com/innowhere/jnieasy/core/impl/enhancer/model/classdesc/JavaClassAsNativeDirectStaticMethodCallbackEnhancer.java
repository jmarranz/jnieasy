/*
 * JavaClassAsNativeDirectStaticMethodCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 18:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectStaticMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectStaticMethodCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeDirectStaticMethodCallbackEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtClass;
import javassist.CtMethod;


/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticMethodCallbackEnhancer extends JavaClassAsNativeDirectMethodCallbackEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectStaticMethodCallbackEnhancer
     */
    public JavaClassAsNativeDirectStaticMethodCallbackEnhancer(JavaClassAsNativeDirectStaticMethodCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);        
    }


    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeDirectStaticMethodCallbackEnhancerRender(this);
    }
  
    public static JavaClassAsNativeDirectStaticMethodCallbackEnhancer newJavaClassAsNativeDirectStaticMethodCallbackEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectStaticMethodCallbackCustomImpl classType = ClassTypeNativeDirectStaticMethodCallbackCustomImpl.registerClassTypeNativeDirectStaticMethodCallbackCustom(ctClass.getName(),ctx.getJNIEasy());
        return (JavaClassAsNativeDirectStaticMethodCallbackEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass,ctx);
    }    
    
    public static JavaClassAsNativeDirectStaticMethodCallbackEnhancer newJavaClassAsNativeDirectStaticMethodCallbackEnhancer(String callbackClassName,CtMethod ctMethod,NativeStaticMethodSignatureImpl signature,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectStaticMethodCallbackCustomImpl classType = ClassTypeNativeDirectStaticMethodCallbackCustomImpl.registerClassTypeNativeDirectStaticMethodCallbackCustom(callbackClassName,ctx.getJNIEasy());
        return (JavaClassAsNativeDirectStaticMethodCallbackEnhancer)newJavaClassAsNativeDirectCallbackEnhancer(callbackClassName,classType,signature,ctMethod,ctx);
    }

    
    public JavaClassAsNativeDirectStaticMethodCallbackImpl getJavaClassAsNativeDirectStaticMethodCallback()
    {
        return (JavaClassAsNativeDirectStaticMethodCallbackImpl)javaClass;
    }
}
