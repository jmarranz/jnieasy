/*
 * TypeNativeMemberReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;

public abstract class TypeNativeMemberReflectionWrapperImpl extends TypeCanBeNativeCapableWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeMemberReflectionWrapperImpl
     */
    public TypeNativeMemberReflectionWrapperImpl(ClassTypeNativeMemberReflectionWrapperImpl dataType)
    {
        super(dataType);
    }    
     
    public TypeNativeMemberReflectionWrapperImpl(ClassTypeNativeMemberReflectionWrapperImpl dataType,TypeNativeMemberReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }    
    
    public TypeNativeMemberReflectionImpl getTypeNativeMemberReflection()
    {
        return (TypeNativeMemberReflectionImpl)getTypeCanBeNativeCapable();
    }

    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeMemberReflectionWrapperImpl(this);
    }        
}
