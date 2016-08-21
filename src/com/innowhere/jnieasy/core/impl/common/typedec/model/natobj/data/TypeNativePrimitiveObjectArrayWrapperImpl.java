/*
 * TypeNativePrimitiveObjectArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectArrayImpl;

public class TypeNativePrimitiveObjectArrayWrapperImpl extends TypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativePrimitiveObjectArrayWrapperImpl
     */
    public TypeNativePrimitiveObjectArrayWrapperImpl(ClassTypeNativePrimitiveObjectArrayWrapperImpl dataType)
    {
        super(dataType);
    }
                         
    public TypeNativePrimitiveObjectArrayWrapperImpl(ClassTypeNativePrimitiveObjectArrayWrapperImpl dataType,TypeNativePrimitiveObjectArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                         
    }    
}
