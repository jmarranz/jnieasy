/*
 * TypeNativeMemberReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeAccessibleReflectionObjectRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeMemberReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;

public abstract class TypeNativeMemberReflectionWrapperRuntimeImpl extends TypeCanBeNativeCapableWrapperRuntimeImpl implements TypeAccessibleReflectionObjectRuntime
{
    /**
     * Creates a new instance of TypeNativeMemberReflectionWrapperRuntimeImpl
     */
    public TypeNativeMemberReflectionWrapperRuntimeImpl(TypeNativeMemberReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }    
    
    public TypeNativeMemberReflectionRuntimeImpl getTypeNativeMemberReflectionRuntime()
    {
        return (TypeNativeMemberReflectionRuntimeImpl)getTypeCanBeNativeCapableRuntime();
    }
}
