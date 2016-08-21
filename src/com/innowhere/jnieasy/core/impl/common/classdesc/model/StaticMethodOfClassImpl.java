/*
 * StaticMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:51
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.StaticMethodOfClassGen;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.StaticMethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import javassist.CtMember;
import javassist.CtMethod;

public class StaticMethodOfClassImpl extends MethodOfClassImpl
{
    
    /**
     * Creates a new instance of StaticMethodOfClassImpl 
     */
    public StaticMethodOfClassImpl(NativeStaticMethodSignatureImpl signature,ClassTypeNativeCapableImpl containerClassType)
    {
        super(signature,containerClassType);
    }
    
    public static StaticMethodOfClassImpl newStaticMethodOfClass(NativeStaticMethodSignatureImpl sig,ClassTypeNativeCapableImpl containerClassType)
    {
        return new StaticMethodOfClassImpl(sig,containerClassType);        
    }

    public NativeStaticMethodSignatureImpl getStaticMethodSignature()
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }
    
    public void setStaticMethodSignature(NativeStaticMethodSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }    
    
    public MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new StaticMethodOfClassGen(this,classGen);
    }
    
    public BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer javaClassEnh)
    {
        return new StaticMethodOfClassEnhancer((CtMethod)ctBehavior,this,javaClassEnh);
    }
    
}
