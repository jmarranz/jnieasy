/*
 * TypeNativeFieldMethodReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFieldMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodReflectionWrapperImpl;

public abstract class TypeNativeFieldMethodReflectionWrapperRuntimeImpl extends TypeNativeBehaviorReflectionWrapperRuntimeImpl implements TypeNativeFieldMethodReflectionRuntime
{
    /** Creates a new instance of TypeNativeFieldMethodReflectionWrapperRuntimeImpl */
    public TypeNativeFieldMethodReflectionWrapperRuntimeImpl(TypeNativeFieldMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
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
