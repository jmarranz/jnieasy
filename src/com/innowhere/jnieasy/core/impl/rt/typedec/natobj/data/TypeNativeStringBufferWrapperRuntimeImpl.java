/*
 * TypeNativeStringBufferWrapperRuntimeImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.data.NativeStringBuffer;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringBufferRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringBufferRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferWrapperImpl;

public abstract class TypeNativeStringBufferWrapperRuntimeImpl extends TypeNativeStringBasedWrapperRuntimeImpl implements  TypeNativeStringBufferRuntime
{
    /** Creates a new instance of TypeNativeStringBufferWrapperRuntimeImpl */
    public TypeNativeStringBufferWrapperRuntimeImpl(TypeNativeStringBufferWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public NativeStringBuffer newStringBuffer(StringBuffer value)
    {
        return (NativeStringBuffer)wrapValue(value);
    }
}
