/*
 * TypeNativeStringBufferRuntimeImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.data.NativeStringBuffer;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringBufferRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBufferWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;

public class TypeNativeStringBufferRuntimeImpl extends TypeNativeStringBasedRuntimeImpl implements TypeNativeStringBufferRuntime
{
    /** Creates a new instance of TypeNativeStringBufferRuntimeImpl */
    public TypeNativeStringBufferRuntimeImpl(TypeNativeStringBufferImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
  
    public NativeStringBuffer newStringBuffer(StringBuffer value)
    {
        return (NativeStringBuffer)wrapValue(value);
    }
    
}
