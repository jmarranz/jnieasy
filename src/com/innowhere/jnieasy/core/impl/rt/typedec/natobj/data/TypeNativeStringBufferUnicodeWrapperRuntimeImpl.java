/*
 * TypeNativeStringBufferUnicodeWrapperRuntimeImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.data.NativeStringBufferUnicode;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.typedec.TypeNativeStringBufferUnicode;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferUnicodeWrapperImpl;

public class TypeNativeStringBufferUnicodeWrapperRuntimeImpl extends TypeNativeStringBufferWrapperRuntimeImpl implements TypeNativeStringBufferUnicode
{
    
    /**
     * Creates a new instance of TypeNativeStringBufferUnicodeWrapperRuntimeImpl
     */
    public TypeNativeStringBufferUnicodeWrapperRuntimeImpl(TypeNativeStringBufferUnicodeWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public NativeStringBufferUnicode newStringBufferUnicode(StringBuffer value)
    {
        return (NativeStringBufferUnicode)wrapValue(value);
    }    
}
