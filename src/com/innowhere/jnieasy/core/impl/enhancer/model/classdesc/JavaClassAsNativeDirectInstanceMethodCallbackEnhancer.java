/*
 * JavaClassAsNativeDirectInstanceMethodCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 18:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectInstanceMethodCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeDirectInstanceMethodCallbackEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtClass;
import javassist.CtMethod;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectInstanceMethodCallbackEnhancer extends JavaClassAsNativeDirectMethodCallbackEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectInstanceMethodCallbackEnhancer
     */
    public JavaClassAsNativeDirectInstanceMethodCallbackEnhancer(JavaClassAsNativeDirectInstanceMethodCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);        
    }
    
    public static JavaClassAsNativeDirectInstanceMethodCallbackEnhancer newJavaClassAsNativeDirectInstanceMethodCallbackEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectInstanceMethodCallbackCustomImpl classType = ClassTypeNativeDirectInstanceMethodCallbackCustomImpl.registerClassTypeNativeDirectInstanceMethodCallbackCustom(ctClass.getName(),ctx.getJNIEasy());

        return (JavaClassAsNativeDirectInstanceMethodCallbackEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass,ctx);
    }      
    
    public static JavaClassAsNativeDirectInstanceMethodCallbackEnhancer newJavaClassAsNativeDirectNoStaticMethodCallbackEnhancer(String callbackClassName,CtMethod ctMethod,NativeInstanceMethodSignatureImpl signature,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectInstanceMethodCallbackCustomImpl classType = ClassTypeNativeDirectInstanceMethodCallbackCustomImpl.registerClassTypeNativeDirectInstanceMethodCallbackCustom(callbackClassName,ctx.getJNIEasy());
       
        return (JavaClassAsNativeDirectInstanceMethodCallbackEnhancer)newJavaClassAsNativeDirectCallbackEnhancer(callbackClassName,classType,signature,ctMethod,ctx);
    }
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeDirectInstanceMethodCallbackEnhancerRender(this);
    }
}
