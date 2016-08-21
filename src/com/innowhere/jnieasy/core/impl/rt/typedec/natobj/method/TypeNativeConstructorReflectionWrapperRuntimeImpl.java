/*
 * TypeNativeConstructorReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeConstructorReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorReflectionWrapperImpl;


public class TypeNativeConstructorReflectionWrapperRuntimeImpl extends TypeNativeBehaviorReflectionWrapperRuntimeImpl implements TypeNativeConstructorReflectionRuntime
{
    /** Creates a new instance of TypeNativeConstructorReflectionWrapperRuntimeImpl */
    public TypeNativeConstructorReflectionWrapperRuntimeImpl(TypeNativeConstructorReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }    
   
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeConstructorSignature)signature;
    }      
        
    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)signature;
    }    
    
    public void setConstructorSignature(NativeConstructorSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
