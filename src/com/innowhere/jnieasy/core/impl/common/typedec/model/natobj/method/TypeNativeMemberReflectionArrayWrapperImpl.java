/*
 * TypeNativeMemberReflectionArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMemberReflectionArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.*;



public class TypeNativeMemberReflectionArrayWrapperImpl extends TypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeMemberReflectionArrayWrapperImpl
     */
    public TypeNativeMemberReflectionArrayWrapperImpl(ClassTypeNativeMemberReflectionArrayWrapperImpl dataType)
    {
        super(dataType);
    }        
                 
    public TypeNativeMemberReflectionArrayWrapperImpl(ClassTypeNativeMemberReflectionArrayWrapperImpl dataType,TypeNativeMemberReflectionArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }   
}
