/*
 * TypeNativeStringWrapperDefaultRuntimeImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringInfoRuntime;

public class TypeNativeStringWrapperDefaultRuntimeImpl extends TypeNativeStringWrapperRuntimeImpl
{
   
    /** Creates a new instance of TypeNativeStringWrapperDefaultRuntimeImpl */
    public TypeNativeStringWrapperDefaultRuntimeImpl(TypeNativeStringWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }    
}
