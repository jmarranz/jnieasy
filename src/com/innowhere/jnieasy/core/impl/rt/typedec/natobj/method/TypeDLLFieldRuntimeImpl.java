/*
 * TypeDLLFieldRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:34
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeDLLFieldImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFieldMethodRuntime;


public abstract class TypeDLLFieldRuntimeImpl extends TypeDLLBehaviorRuntimeImpl implements TypeNativeFieldMethodRuntime
{
    
    /**
     * Creates a new instance of TypeDLLFieldRuntimeImpl
     */
    public TypeDLLFieldRuntimeImpl(TypeDLLFieldImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeFieldMethodSignature)signature;
    }
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)signature;
    }
    
    public void setFieldMethodSignature(NativeFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }    
}
