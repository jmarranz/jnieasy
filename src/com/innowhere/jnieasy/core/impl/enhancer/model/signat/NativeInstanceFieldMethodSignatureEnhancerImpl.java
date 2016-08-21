/*
 * NativeInstanceFieldMethodSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectInstanceFieldCallbackEnhancer;
import javassist.CtField;
import javassist.CtMember;

/**
 *
 * @author jmarranz
 */
public class NativeInstanceFieldMethodSignatureEnhancerImpl extends NativeFieldMethodSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeInstanceFieldMethodSignatureEnhancerImpl
     */
    public NativeInstanceFieldMethodSignatureEnhancerImpl(NativeInstanceFieldMethodSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }

    public NativeInstanceFieldMethodSignatureImpl getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignatureImpl)signature;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx)
    {
        return JavaClassAsNativeDirectInstanceFieldCallbackEnhancer.newJavaClassAsNativeDirectInstanceFieldCallbackEnhancer(containerClassName,(CtField)ctMember,getInstanceFieldMethodSignature(),esctx);
    }        
}
