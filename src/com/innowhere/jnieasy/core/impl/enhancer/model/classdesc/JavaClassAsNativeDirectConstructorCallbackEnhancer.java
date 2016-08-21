/*
 * JavaClassAsNativeDirectConstructorCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 18:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectConstructorCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeDirectConstructorCallbackEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtClass;
import javassist.CtConstructor;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectConstructorCallbackEnhancer extends JavaClassAsNativeDirectCallbackEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectConstructorCallbackEnhancer
     */
    public JavaClassAsNativeDirectConstructorCallbackEnhancer(JavaClassAsNativeDirectConstructorCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);     
    }
    
    public static JavaClassAsNativeDirectConstructorCallbackEnhancer newJavaClassAsNativeDirectConstructorCallbackEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectConstructorCallbackCustomImpl classType = ClassTypeNativeDirectConstructorCallbackCustomImpl.registerClassTypeNativeDirectConstructorCallbackCustom(ctClass.getName(),ctx.getJNIEasy());
        JavaClassAsNativeDirectConstructorCallbackEnhancer javaClassEnh = (JavaClassAsNativeDirectConstructorCallbackEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass,ctx);
        return javaClassEnh;
    }
     
    public static JavaClassAsNativeDirectConstructorCallbackEnhancer newJavaClassAsNativeDirectConstructorCallbackEnhancer(String callbackClassName,CtConstructor ctConstruc,NativeConstructorSignatureImpl signature,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectConstructorCallbackCustomImpl classType = ClassTypeNativeDirectConstructorCallbackCustomImpl.registerClassTypeNativeDirectConstructorCallbackCustom(callbackClassName,ctx.getJNIEasy());
       
        return (JavaClassAsNativeDirectConstructorCallbackEnhancer)newJavaClassAsNativeDirectCallbackEnhancer(callbackClassName,classType,signature,ctConstruc,ctx);
    }  
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeDirectConstructorCallbackEnhancerRender(this);
    }
    

    public JavaClassAsNativeDirectConstructorCallbackImpl getJavaClassAsNativeDirectConstructorCallback()
    {
        return (JavaClassAsNativeDirectConstructorCallbackImpl)javaClass;
    }
    
}
