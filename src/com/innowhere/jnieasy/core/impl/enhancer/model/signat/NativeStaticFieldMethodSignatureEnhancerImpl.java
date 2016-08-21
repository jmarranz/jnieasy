/*
 * NativeStaticFieldMethodSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:34
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticFieldCallbackEnhancer;
import javassist.CtField;
import javassist.CtMember;

/**
 *
 * @author jmarranz
 */
public class NativeStaticFieldMethodSignatureEnhancerImpl extends NativeFieldMethodSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeStaticFieldMethodSignatureEnhancerImpl
     */
    public NativeStaticFieldMethodSignatureEnhancerImpl(NativeStaticFieldMethodSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }
        
    public NativeStaticFieldMethodSignatureImpl getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx)
    {
        return JavaClassAsNativeDirectStaticFieldCallbackEnhancer.newJavaClassAsNativeDirectStaticFieldCallbackEnhancer(containerClassName,(CtField)ctMember,getStaticFieldMethodSignature(),esctx);
    }       
}
