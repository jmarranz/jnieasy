/*
 * TypeNativeInstanceMethodReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceMethodReflectionWrapperImpl;


public class TypeNativeInstanceMethodReflectionWrapperRuntimeImpl extends TypeNativeMethodReflectionWrapperRuntimeImpl implements TypeNativeInstanceMethodReflectionRuntime
{
    /**
     * Creates a new instance of TypeNativeInstanceMethodReflectionWrapperRuntimeImpl
     */
    public TypeNativeInstanceMethodReflectionWrapperRuntimeImpl(TypeNativeInstanceMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeInstanceMethodSignature)signature;
    }
    
    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)signature;
    }    
    
    public void setInstanceMethodSignature(NativeInstanceMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
