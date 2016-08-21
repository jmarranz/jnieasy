/*
 * TypeNativeMethodReflectionWrapperDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodReflectionWrapperImpl;


public class TypeNativeMethodReflectionWrapperDefaultRuntimeImpl extends TypeNativeMethodReflectionWrapperRuntimeImpl
{
    /** Creates a new instance of TypeNativeMethodReflectionWrapperDefaultRuntimeImpl */
    public TypeNativeMethodReflectionWrapperDefaultRuntimeImpl(TypeNativeMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }    
   
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeMethodSignature)signature;
    }      
}
