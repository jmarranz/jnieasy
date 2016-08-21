/*
 * TypeDLLMethodRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:34
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeMethodRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeDLLMethodImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public abstract class TypeDLLMethodRuntimeImpl extends TypeDLLBehaviorRuntimeImpl implements TypeNativeMethodRuntime
{
    
    /**
     * Creates a new instance of TypeDLLMethodRuntimeImpl
     */
    public TypeDLLMethodRuntimeImpl(TypeDLLMethodImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeMethodSignature)signature;
    }
    
    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)signature;
    }
    
    public void setMethodSignature(NativeMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }    
}
