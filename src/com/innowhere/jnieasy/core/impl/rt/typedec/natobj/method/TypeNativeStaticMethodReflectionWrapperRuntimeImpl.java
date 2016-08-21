/*
 * TypeNativeStaticMethodReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticMethodReflectionWrapperImpl;


public class TypeNativeStaticMethodReflectionWrapperRuntimeImpl extends TypeNativeMethodReflectionWrapperRuntimeImpl implements TypeNativeStaticMethodReflectionRuntime
{
    /** Creates a new instance of TypeNativeStaticMethodReflectionWrapperRuntimeImpl */
    public TypeNativeStaticMethodReflectionWrapperRuntimeImpl(TypeNativeStaticMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeStaticMethodSignature)signature;
    }
        
    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)signature;
    }    
    
    public void setStaticMethodSignature(NativeStaticMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }
 
}
