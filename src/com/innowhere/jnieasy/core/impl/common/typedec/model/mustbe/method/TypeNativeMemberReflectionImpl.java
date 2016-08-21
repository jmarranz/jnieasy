/*
 * TypeNativeMemberReflectionImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;

public abstract class TypeNativeMemberReflectionImpl extends TypeCanBeNativeCapableImpl
{
   
    /**
     * Creates a new instance of TypeNativeMemberReflectionImpl
     */
    public TypeNativeMemberReflectionImpl(ClassTypeNativeMemberReflectionImpl dataType)
    {
        super(dataType);
    }    
    
    public TypeNativeMemberReflectionImpl(ClassTypeNativeMemberReflectionImpl dataType,TypeNativeMemberReflectionWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }        
    
    public TypeNativeMemberReflectionWrapperImpl getTypeNativeMemberReflectionWrapper()
    {
        return (TypeNativeMemberReflectionWrapperImpl)getTypeCanBeNativeCapableWrapper();
    }

    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeMemberReflectionImpl(this);
    }    
}
