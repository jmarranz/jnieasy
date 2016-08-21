/*
 * ConstructorSignatureEnhancerImpl.java
 *
 * Created on 5 de septiembre de 2005, 12:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.signat;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerUtil;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectConstructorCallbackEnhancer;
import javassist.CtConstructor;
import javassist.CtMember;
import javassist.NotFoundException;

/**
 *
 * @author jmarranz
 */
public class ConstructorSignatureEnhancerImpl extends NativeBehaviorSignatureEnhancerImpl
{
    
    /**
     * Creates a new instance of ConstructorSignatureEnhancerImpl 
     */
    public ConstructorSignatureEnhancerImpl(NativeConstructorSignatureImpl signature,NativeEnhancerImpl enhancer)
    {
        super(signature,enhancer);
    }
        
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)signature;
    }
    
    public String formNativeDirectCallbackUniqueClassName(CtMember behavior)
    {
        try
        {
            CtConstructor construc = (CtConstructor)behavior;
            NativeConstructorSignatureImpl sig = getConstructorSignature();            
            return sig.formNativeDirectCallbackUniqueClassName(construc.getDeclaringClass().getName(),EnhancerUtil.extractClassNames(construc.getParameterTypes()));
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }   
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(String containerClassName,CtMember ctMember,EnhancerSharedContext esctx)
    {
        return JavaClassAsNativeDirectConstructorCallbackEnhancer.newJavaClassAsNativeDirectConstructorCallbackEnhancer(containerClassName,(CtConstructor)ctMember,getConstructorSignature(),esctx);
    }    
}
