/*
 * NativeInstanceMethodSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectInstanceMethodCallbackEnhancer;
import javassist.CtMember;
import javassist.CtMethod;

/**
 *
 * @author jmarranz
 */
public class NativeInstanceMethodSignatureEnhancerImpl extends MethodSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeInstanceMethodSignatureEnhancerImpl
     */
    public NativeInstanceMethodSignatureEnhancerImpl(NativeInstanceMethodSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }
    
    public NativeInstanceMethodSignatureImpl getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignatureImpl)signature;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx)
    {
        return JavaClassAsNativeDirectInstanceMethodCallbackEnhancer.newJavaClassAsNativeDirectNoStaticMethodCallbackEnhancer(containerClassName,(CtMethod)ctMember,getInstanceMethodSignature(),esctx);
    }    
}
