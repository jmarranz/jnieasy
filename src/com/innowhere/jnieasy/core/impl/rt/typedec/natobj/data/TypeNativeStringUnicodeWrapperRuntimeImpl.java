/*
 * TypeNativeStringUnicodeWrapperRuntimeImpl.java
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
import com.innowhere.jnieasy.core.typedec.TypeNativeStringUnicode;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringUnicodeWrapperImpl;

public class TypeNativeStringUnicodeWrapperRuntimeImpl extends TypeNativeStringWrapperRuntimeImpl implements TypeNativeStringUnicode
{
    
    /** Creates a new instance of TypeNativeStringUnicodeWrapperRuntimeImpl */
    public TypeNativeStringUnicodeWrapperRuntimeImpl(TypeNativeStringUnicodeWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public NativeStringUnicode newStringUnicode(String value)
    {
        return (NativeStringUnicode)wrapValue(value);
    }    
}
