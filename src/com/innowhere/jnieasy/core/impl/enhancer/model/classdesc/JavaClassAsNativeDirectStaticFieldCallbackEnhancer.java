/*
 * JavaClassAsNativeDirectStaticFieldCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 18:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectStaticFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectStaticFieldCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeDirectStaticFieldCallbackEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtClass;
import javassist.CtField;



/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticFieldCallbackEnhancer extends JavaClassAsFieldCallbackEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectStaticFieldCallbackEnhancer
     */
    public JavaClassAsNativeDirectStaticFieldCallbackEnhancer(JavaClassAsNativeDirectStaticFieldCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);        
    }

  
    public static JavaClassAsNativeDirectStaticFieldCallbackEnhancer newJavaClassAsNativeDirectStaticFieldCallbackEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectStaticFieldCallbackCustomImpl classType = ClassTypeNativeDirectStaticFieldCallbackCustomImpl.registerClassTypeNativeDirectStaticFieldCallbackCustom(ctClass.getName(),ctx.getJNIEasy());

        JavaClassAsNativeDirectStaticFieldCallbackEnhancer javaClassEnh = (JavaClassAsNativeDirectStaticFieldCallbackEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass,ctx);
        //javaClassEnh.setCtClass(ctClass);
        return javaClassEnh;
    }    
    
    public static JavaClassAsNativeDirectStaticFieldCallbackEnhancer newJavaClassAsNativeDirectStaticFieldCallbackEnhancer(String callbackClassName,CtField ctField,NativeStaticFieldMethodSignatureImpl signature,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectStaticFieldCallbackCustomImpl classType = ClassTypeNativeDirectStaticFieldCallbackCustomImpl.registerClassTypeNativeDirectStaticFieldCallbackCustom(callbackClassName,ctx.getJNIEasy());
        CtClass ctClassCallback = createClassFromScratch(callbackClassName,ctx);

        return (JavaClassAsNativeDirectStaticFieldCallbackEnhancer)newJavaClassAsNativeDirectCallbackEnhancer(ctClassCallback,classType,signature,ctField,ctx);
    } 
   
    
    public JavaClassAsNativeDirectStaticFieldCallbackImpl getJavaClassAsNativeDirectStaticFieldCallback()
    {
        return (JavaClassAsNativeDirectStaticFieldCallbackImpl)javaClass;
    }

    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeDirectStaticFieldCallbackEnhancerRender(this);
    }    
}
