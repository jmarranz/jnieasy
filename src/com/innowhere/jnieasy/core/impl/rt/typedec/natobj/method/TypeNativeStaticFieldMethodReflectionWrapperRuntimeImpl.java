/*
 * TypeNativeStaticFieldMethodReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticFieldMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticFieldMethodReflectionWrapperImpl;



public class TypeNativeStaticFieldMethodReflectionWrapperRuntimeImpl extends TypeNativeFieldMethodReflectionWrapperRuntimeImpl implements TypeNativeStaticFieldMethodReflectionRuntime
{
    /**
     * Creates a new instance of TypeNativeStaticFieldMethodReflectionWrapperRuntimeImpl
     */
    public TypeNativeStaticFieldMethodReflectionWrapperRuntimeImpl(TypeNativeStaticFieldMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeStaticFieldMethodSignature)signature;
    }      
            
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)signature;
    }    
    
    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }
 
}
