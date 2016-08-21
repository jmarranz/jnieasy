/*
 * TypeNativeFieldMethodReflectionWrapperDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;


public class TypeNativeFieldMethodReflectionWrapperDefaultRuntimeImpl extends TypeNativeFieldMethodReflectionWrapperRuntimeImpl
{
    /** Creates a new instance of TypeNativeFieldMethodReflectionWrapperDefaultRuntimeImpl */
    public TypeNativeFieldMethodReflectionWrapperDefaultRuntimeImpl(TypeNativeFieldMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }    

    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeFieldMethodSignature)signature;
    }          
}
