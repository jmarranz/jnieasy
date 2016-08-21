/*
 * TypeNativeObjectArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeObjectArrayImpl;

public abstract class TypeNativeObjectArrayWrapperImpl extends TypeNativeArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeObjectArrayWrapperImpl
     */
    public TypeNativeObjectArrayWrapperImpl(ClassTypeNativeObjectArrayWrapperImpl dataType)
    {
        super(dataType);
    }

    public TypeNativeObjectArrayWrapperImpl(ClassTypeNativeObjectArrayWrapperImpl dataType,TypeNativeObjectArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }     
}
