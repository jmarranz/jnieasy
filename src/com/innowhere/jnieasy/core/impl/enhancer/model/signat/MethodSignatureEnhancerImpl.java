/*
 * MethodSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:34
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerUtil;
import javassist.CtMember;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 *
 * @author jmarranz
 */
public abstract class MethodSignatureEnhancerImpl extends NativeBehaviorSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of MethodSignatureEnhancerImpl 
     */
    public MethodSignatureEnhancerImpl(NativeMethodSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }
    
    public NativeMethodSignatureImpl getNativeMethodSignature()
    {
        return (NativeMethodSignatureImpl)signature;
    }
    
    public String formNativeDirectCallbackUniqueClassName(CtMember behavior)
    {
        try
        {
            CtMethod method = (CtMethod)behavior; 
            NativeMethodSignatureImpl sig = getNativeMethodSignature();
            return sig.formNativeDirectCallbackUniqueClassName(method.getDeclaringClass().getName(),method.getName(),EnhancerUtil.extractClassNames(method.getParameterTypes()));
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }    
}
