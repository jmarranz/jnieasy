/*
 * NativeBehaviorSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtMember;

/**
 *
 * @author jmarranz
 */
public abstract class NativeBehaviorSignatureEnhancerImpl
{
    protected NativeBehaviorSignatureImpl signature;
    protected NativeEnhancerImpl enhancer;
    
    /**
     * Creates a new instance of NativeBehaviorSignatureEnhancerImpl
     */
    public NativeBehaviorSignatureEnhancerImpl(NativeBehaviorSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        this.signature = signature;
        this.enhancer = enhancer;
    }
    
    public static NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeBehaviorSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        return signature.newBehaviorSignatureEnhancer(enhancer);
    }
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer getJavaClassAsNativeDirectCallbackEnhancer(CtMember ctMember,EnhancerSharedContext esctx)
    {    
        String containerClassName = formNativeDirectCallbackUniqueClassName(ctMember);
        return getJavaClassAsNativeDirectCallbackEnhancer(containerClassName,ctMember,esctx);
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer getJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx)
    {
        JavaClassAsNativeDirectCallbackEnhancer javaClassEnh = (JavaClassAsNativeDirectCallbackEnhancer)esctx.getTypeEnhancer(containerClassName);        
        if (javaClassEnh == null)
        {
            javaClassEnh = newJavaClassAsNativeDirectCallbackEnhancer(containerClassName,ctMember,esctx);  
        }

        if (!javaClassEnh.isEnhanced()) 
        {      
            PackageEnhancer pkgEnh = PackageEnhancer.getDefaultPackageEnhancer();
            EnhancerSourceFileContext ctx = esctx.newEnhancerSourceFileContext(pkgEnh);         
            JavaClassAsNativeCapableEnhancerRender javaClassEnhRender = JavaClassAsNativeCapableEnhancerRender.newJavaClassAsNativeCapableEnhancerRender(javaClassEnh);
            javaClassEnhRender.enhance(ctx);
        }

        return javaClassEnh;
    }
    
    public abstract String formNativeDirectCallbackUniqueClassName(CtMember behavior);
    public abstract JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx);    
    
}
