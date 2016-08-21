/*
 * TypeNativeObjectRuntimeImpl.java
 *
 * Created on 2 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;

public abstract class TypeNativeObjectRuntimeImpl extends TypeNativeRuntimeImpl implements TypeNativeObjectRuntime
{
    
    /**
     * Creates a new instance of TypeNativeObjectRuntimeImpl
     */
    public TypeNativeObjectRuntimeImpl(TypeNativeObjectImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public static TypeNativeObjectRuntimeImpl newTypeNativeObjectRuntime(Object value,RuntimeContext ctx)
    {    
        if (value instanceof NativeCapable)
            return TypeNativeCapableRuntimeImpl.newTypeNativeCapableRuntime((NativeCapableInternal)value,ctx);
        else
            return TypeCanBeNativeCapableRuntimeImpl.newTypeCanBeNativeCapableRuntime(value,ctx);
    }    

    
    public ClassTypeNativeObjectRuntimeImpl getClassTypeNativeObjectRuntime()
    {
        return (ClassTypeNativeObjectRuntimeImpl)getClassTypeRuntime();
    }    
    
    public abstract Object getObject(NativeAddressImpl addr,long offset);    
    
    public Object getObject(long addr)
    {    
        if (addr == 0) return null;
        return getObject(new NativeAddressImpl(addr), 0);
    }            
}
