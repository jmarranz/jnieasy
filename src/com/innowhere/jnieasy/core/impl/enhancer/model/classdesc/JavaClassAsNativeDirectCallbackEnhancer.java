/*
 * JavaClassAsNativeDirectCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 12:12
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeDirectCallbackEnhancerXML;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeCapableEnhancerXML;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeDirectCallbackTemplateImpl;
import javassist.CtClass;
import javassist.CtMember;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectCallbackEnhancer extends JavaClassAsNativeCapableEnhancer
{
    protected BehaviorOfClassEnhancer behaviorEnh;
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectCallbackEnhancer
     */
    public JavaClassAsNativeDirectCallbackEnhancer(JavaClassAsNativeDirectCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx); 
    }
    
    public BehaviorOfClassEnhancer getBehaviorOfClassEnhancer()
    {
        return behaviorEnh;
    }

    public void setBehaviorOfClassEnhancer(BehaviorOfClassEnhancer behaviorEnh) 
    {     
        this.behaviorEnh = behaviorEnh;
        getJavaClassAsNativeDirectCallback().setBehaviorOfClass(behaviorEnh.getBehaviorOfClass());
    }

    public JavaClassAsNativeDirectCallbackImpl getJavaClassAsNativeDirectCallback()
    {
        return (JavaClassAsNativeDirectCallbackImpl)javaClass;
    }
   
    public static JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String callbackClassName,ClassTypeNativeCapableImpl classType,NativeBehaviorSignatureImpl signature,CtMember ctBehavior,EnhancerSharedContext ctx)
    {  
        CtClass ctClassCallback = createClassFromScratch(callbackClassName,ctx);
        return newJavaClassAsNativeDirectCallbackEnhancer(ctClassCallback, classType, signature, ctBehavior, ctx);
    }
    
    public static JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClassCallback,ClassTypeNativeCapableImpl classType,NativeBehaviorSignatureImpl signature,CtMember ctBehavior,EnhancerSharedContext ctx)
    {
        try
        {        
            JavaClassAsNativeDirectCallbackEnhancer javaClassEnh = (JavaClassAsNativeDirectCallbackEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClassCallback,ctx);
            //javaClassEnh.setCtClass(ctClassCallback);

            CtClass ctClassMethodContainer = ctBehavior.getDeclaringClass(); 

            JavaClassAsNativeMultipleFieldContainerEnhancer containerJavaClassEnh = getMethodContainerJavaClass(ctClassMethodContainer,ctx);
            BehaviorOfClassImpl behaviorOfClass = BehaviorOfClassImpl.newBehaviorOfClass(signature,containerJavaClassEnh.getClassTypeMultipleFieldContainer());
            BehaviorOfClassEnhancer behaviorEnh = BehaviorOfClassEnhancer.newBehaviorOfClassEnhancer(ctBehavior,behaviorOfClass,containerJavaClassEnh);

            javaClassEnh.setBehaviorOfClassEnhancer(behaviorEnh);
            return javaClassEnh;
        }
        catch(JNIEasyException ex)
        {
            // Evitamos que quede registrado un fallido intento, 
            // útil cuando se usa JNIEasyLibrary.exportClassBehaviorsByDefault(...)
            // con useReflection = false y silenciando métodos que no sean válidos
            // pues con estos métodos el usuario no es alertado (no llega la excepción)
            // y queda registrado un object no válido
            ctx.removeEnhancer(ctClassCallback);
            throw ex;
        }
    }
    
    public JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML()
    {
        return new JavaClassAsNativeDirectCallbackEnhancerXML(this);
    }  
    
    public static CtClass createClassFromScratch(String className,EnhancerSharedContext ctx)
    {
        return ctx.createClassFromScratch(NativeDirectCallbackTemplateImpl.class,className); 
    }    
    
    public static JavaClassAsNativeMultipleFieldContainerEnhancer getMethodContainerJavaClass(CtClass ctClassContainer,EnhancerSharedContext ctx)
    {    
        // Es posible que sea enhanceable y sea del tipo apropiado
        JavaClassAsNativeMultipleFieldContainerEnhancer javaClassContainer = (JavaClassAsNativeMultipleFieldContainerEnhancer)ctx.getTypeEnhancer(ctClassContainer);
        if (javaClassContainer == null) // no es enhanceable, es una clase normal Java
        {
            javaClassContainer = JavaClassAsNativeMultipleFieldContainerUnknownEnhancer.newJavaClassAsMultipleFieldContainerUnknownEnhancer(ctClassContainer,ctx);                     
            //ctx.putTypeEnhancer(ctClassContainer, javaClassContainer);
        }
        return javaClassContainer;        
    } 
    
    public static JavaClassAsNativeMultipleFieldContainerEnhancer getMethodContainerJavaClass(String className,EnhancerSourceFileContext ctx)
    {
        CtClass ctClassMethodContainer = ctx.getCtClass(className); // así aseguramos que existe y que el nombre asociado es absoluto (pues el ctx.getCtClass() puede usar imports)
        return getMethodContainerJavaClass(ctClassMethodContainer, ctx.getParentContext());
    }    
}
