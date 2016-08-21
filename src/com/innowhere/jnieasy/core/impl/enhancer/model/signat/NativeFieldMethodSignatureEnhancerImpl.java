/*
 * NativeFieldMethodSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import javassist.CtField;
import javassist.CtMember;

/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodSignatureEnhancerImpl extends NativeBehaviorSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeFieldMethodSignatureEnhancerImpl
     */
    public NativeFieldMethodSignatureEnhancerImpl(NativeFieldMethodSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }
    
    public NativeFieldMethodSignatureImpl getNativeFieldMethodSignature()
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }
    
    public String formNativeDirectCallbackUniqueClassName(CtMember behavior)
    {
        CtField field = (CtField)behavior;
        NativeFieldMethodSignatureImpl sig = getNativeFieldMethodSignature();     
        return sig.formNativeDirectCallbackUniqueClassName(field.getDeclaringClass().getName(),field.getName());        
    }        
}
