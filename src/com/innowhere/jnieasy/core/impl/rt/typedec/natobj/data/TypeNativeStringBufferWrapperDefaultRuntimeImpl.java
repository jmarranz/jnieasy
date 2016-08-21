/*
 * TypeNativeStringBufferWrapperDefaultRuntimeImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferWrapperImpl;

public class TypeNativeStringBufferWrapperDefaultRuntimeImpl extends TypeNativeStringBufferWrapperRuntimeImpl
{
    /** Creates a new instance of TypeNativeStringBufferWrapperDefaultRuntimeImpl */
    public TypeNativeStringBufferWrapperDefaultRuntimeImpl(TypeNativeStringBufferWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

}
