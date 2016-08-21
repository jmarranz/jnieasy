/*
 * TypeNativeStringBufferArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;

public abstract class TypeNativeStringBufferArrayWrapperImpl extends TypeNativeStringBasedArrayWrapperImpl
{

    /**
     * Creates a new instance of TypeNativeStringBufferArrayWrapperImpl
     */
    public TypeNativeStringBufferArrayWrapperImpl(ClassTypeNativeStringBufferArrayWrapperImpl dataType)
    {
        super(dataType);
    }
                     
    public TypeNativeStringBufferArrayWrapperImpl(ClassTypeNativeStringBufferArrayWrapperImpl dataType,TypeNativeStringBufferArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);          
    }          
}
