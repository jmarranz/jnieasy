/*
 * TypeNativeArrayOfArrayWrapperImpl.java
 *
 * Created on 3 de diciembre de 2004, 11:04
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayOfArrayImpl;

public class TypeNativeArrayOfArrayWrapperImpl extends TypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeArrayOfArrayWrapperImpl
     */
    public TypeNativeArrayOfArrayWrapperImpl(ClassTypeNativeArrayOfArrayWrapperImpl dataType)
    {
        super(dataType);
    }    
                         
    public TypeNativeArrayOfArrayWrapperImpl(ClassTypeNativeArrayOfArrayWrapperImpl dataType,TypeNativeArrayOfArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                         
    }    
}
