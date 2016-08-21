/*
 * ClassTypeNativeStringBasedArrayWrapperImpl.java
 *
 * Created on 11 de febrero de 2005, 11:54
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBasedArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedArrayImpl;

public abstract class TypeNativeStringBasedArrayWrapperImpl extends TypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeStringBasedArrayWrapperImpl
     */
    public TypeNativeStringBasedArrayWrapperImpl(ClassTypeNativeStringBasedArrayWrapperImpl dataType)
    {
        super(dataType);
    }
                     
    public TypeNativeStringBasedArrayWrapperImpl(ClassTypeNativeStringBasedArrayWrapperImpl dataType,TypeNativeStringBasedArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);      
    }    
}
