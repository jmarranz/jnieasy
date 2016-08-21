/*
 * TypeNativePrimitiveArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveArrayImpl;

public class TypeNativePrimitiveArrayWrapperImpl extends TypeNativeArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativePrimitiveArrayWrapperImpl
     */
    public TypeNativePrimitiveArrayWrapperImpl(ClassTypeNativePrimitiveArrayWrapperImpl dataType)
    {
        super(dataType);
    }    
                             
    public TypeNativePrimitiveArrayWrapperImpl(ClassTypeNativePrimitiveArrayWrapperImpl dataType,TypeNativePrimitiveArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                         
    }          
}

