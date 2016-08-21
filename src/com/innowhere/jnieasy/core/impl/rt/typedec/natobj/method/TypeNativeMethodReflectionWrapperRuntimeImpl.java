/*
 * TypeNativeMethodReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodReflectionWrapperImpl;



public abstract class TypeNativeMethodReflectionWrapperRuntimeImpl extends TypeNativeBehaviorReflectionWrapperRuntimeImpl implements TypeNativeMethodReflectionRuntime
{
    /** Creates a new instance of TypeNativeMethodReflectionWrapperRuntimeImpl */
    public TypeNativeMethodReflectionWrapperRuntimeImpl(TypeNativeMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
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
