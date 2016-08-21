/*
 * TypeCanBeNativeCapableArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCanBeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableArrayImpl;

public abstract class TypeCanBeNativeCapableArrayWrapperImpl extends TypeNativeObjectArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeCanBeNativeCapableArrayWrapperImpl
     */
    public TypeCanBeNativeCapableArrayWrapperImpl(ClassTypeCanBeNativeCapableArrayWrapperImpl dataType)
    {
        super(dataType);
    }
                 
    public TypeCanBeNativeCapableArrayWrapperImpl(ClassTypeCanBeNativeCapableArrayWrapperImpl dataType,TypeCanBeNativeCapableArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }    
}
