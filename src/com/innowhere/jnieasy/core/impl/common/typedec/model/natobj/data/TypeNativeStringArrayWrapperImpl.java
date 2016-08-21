/*
 * TypeNativeStringArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;

public abstract class TypeNativeStringArrayWrapperImpl extends TypeNativeStringBasedArrayWrapperImpl
{

    /**
     * Creates a new instance of TypeNativeStringArrayWrapperImpl
     */
    public TypeNativeStringArrayWrapperImpl(ClassTypeNativeStringArrayWrapperImpl dataType)
    {
        super(dataType);
    }
                     
    public TypeNativeStringArrayWrapperImpl(ClassTypeNativeStringArrayWrapperImpl dataType,TypeNativeStringArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);      
    }    
}
