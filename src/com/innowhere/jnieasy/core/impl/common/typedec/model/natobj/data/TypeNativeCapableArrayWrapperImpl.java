/*
 * TypeNativeCapableArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeCapableArrayImpl;

public class TypeNativeCapableArrayWrapperImpl extends TypeNativeObjectArrayWrapperImpl
{

    /**
     * Creates a new instance of TypeNativeCapableArrayWrapperImpl
     */
    public TypeNativeCapableArrayWrapperImpl(ClassTypeNativeCapableArrayWrapperImpl dataType)
    {
        super(dataType);
    }
 
    public TypeNativeCapableArrayWrapperImpl(ClassTypeNativeCapableArrayWrapperImpl dataType,TypeNativeCapableArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }    
        
}
