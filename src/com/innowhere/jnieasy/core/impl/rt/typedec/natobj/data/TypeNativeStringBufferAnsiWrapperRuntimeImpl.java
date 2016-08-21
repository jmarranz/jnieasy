/*
 * TypeNativeStringBufferAnsiWrapperRuntimeImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.typedec.TypeNativeStringBufferAnsi;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringInfoRuntime;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

public class TypeNativeStringBufferAnsiWrapperRuntimeImpl extends TypeNativeStringBufferWrapperRuntimeImpl implements TypeNativeStringBufferAnsi
{
    
    /**
     * Creates a new instance of TypeNativeStringBufferAnsiWrapperRuntimeImpl
     */
    public TypeNativeStringBufferAnsiWrapperRuntimeImpl(TypeNativeStringBufferAnsiWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public NativeStringBufferAnsi newStringBufferAnsi(StringBuffer value)
    {
        return (NativeStringBufferAnsi)wrapValue(value);
    }    
}
