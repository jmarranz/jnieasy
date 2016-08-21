/*
 * JavaClassAsNativeDirectInstanceFieldCallbackEnhancer.java
 *
 * Created on 7 de julio de 2005, 18:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeDirectInstanceFieldCallbackEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtClass;
import javassist.CtField;


/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectInstanceFieldCallbackEnhancer extends JavaClassAsFieldCallbackEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectInstanceFieldCallbackEnhancer
     */
    public JavaClassAsNativeDirectInstanceFieldCallbackEnhancer(JavaClassAsNativeDirectInstanceFieldCallbackImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);        
    }
    
    public static JavaClassAsNativeDirectInstanceFieldCallbackEnhancer newJavaClassAsNativeDirectInstanceFieldCallbackEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectInstanceFieldCallbackCustomImpl classType = ClassTypeNativeDirectInstanceFieldCallbackCustomImpl.registerClassTypeNativeDirectInstanceFieldCallbackCustom(ctClass.getName(),ctx.getJNIEasy());
        
        JavaClassAsNativeDirectInstanceFieldCallbackImpl javaClass = (JavaClassAsNativeDirectInstanceFieldCallbackImpl)classType.getJavaClassAsNativeCapable();
        return new JavaClassAsNativeDirectInstanceFieldCallbackEnhancer(javaClass,ctx);
    }    
    
    public static JavaClassAsNativeDirectInstanceFieldCallbackEnhancer newJavaClassAsNativeDirectInstanceFieldCallbackEnhancer(String callbackClassName,CtField ctField,NativeInstanceFieldMethodSignatureImpl signature,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        ClassTypeNativeDirectInstanceFieldCallbackCustomImpl classType = ClassTypeNativeDirectInstanceFieldCallbackCustomImpl.registerClassTypeNativeDirectInstanceFieldCallbackCustom(callbackClassName,ctx.getJNIEasy());
        CtClass ctClassCallback = createClassFromScratch(callbackClassName,ctx);

        return (JavaClassAsNativeDirectInstanceFieldCallbackEnhancer)newJavaClassAsNativeDirectCallbackEnhancer(ctClassCallback,classType,signature,ctField,ctx);
    }
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeDirectInstanceFieldCallbackEnhancerRender(this);
    }
}
