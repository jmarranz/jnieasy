/*
 * TypeNativeStringAnsiWrapperRuntimeImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.data.NativeStringAnsi;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.typedec.TypeNativeStringAnsi;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringAnsiWrapperImpl;

public class TypeNativeStringAnsiWrapperRuntimeImpl extends TypeNativeStringWrapperRuntimeImpl implements TypeNativeStringAnsi
{
    
    /**
     * Creates a new instance of TypeNativeStringAnsiWrapperRuntimeImpl
     */
    public TypeNativeStringAnsiWrapperRuntimeImpl(TypeNativeStringAnsiWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public NativeStringAnsi newStringAnsi(String value)
    {
        return (NativeStringAnsi)wrapValue(value);
    }

}
