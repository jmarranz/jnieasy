/*
 * NativeStaticMethodSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticMethodCallbackEnhancer;
import javassist.CtMember;
import javassist.CtMethod;

/**
 *
 * @author jmarranz
 */
public class NativeStaticMethodSignatureEnhancerImpl extends MethodSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeStaticMethodSignatureEnhancerImpl
     */
    public NativeStaticMethodSignatureEnhancerImpl(NativeStaticMethodSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }
        
    public NativeStaticMethodSignatureImpl getStaticMethodSignature()
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx)
    {
        return JavaClassAsNativeDirectStaticMethodCallbackEnhancer.newJavaClassAsNativeDirectStaticMethodCallbackEnhancer(containerClassName,(CtMethod)ctMember,getStaticMethodSignature(),esctx);
    }    
}
