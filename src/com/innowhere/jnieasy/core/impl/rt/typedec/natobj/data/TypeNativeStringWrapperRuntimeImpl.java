/*
 * TypeNativeStringRuntimeImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.data.NativeString;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperImpl;

public abstract class TypeNativeStringWrapperRuntimeImpl extends TypeNativeStringBasedWrapperRuntimeImpl implements TypeNativeStringRuntime
{

    /**
     * Creates a new instance of TypeNativeStringRuntimeImpl
     */
    public TypeNativeStringWrapperRuntimeImpl(TypeNativeStringWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public TypeNativeStringRuntimeImpl getTypeNativeStringRuntime()
    {
        return (TypeNativeStringRuntimeImpl)getTypeCanBeNativeCapableRuntime();
    }
    
    public TypeNativeStringWrapperImpl getTypeNativeStringWrapper()
    {
        return (TypeNativeStringWrapperImpl)typeDec;
    }    
    
    public NativeString newString(String value)
    {
        return (NativeString)wrapValue(value);
    }
}
