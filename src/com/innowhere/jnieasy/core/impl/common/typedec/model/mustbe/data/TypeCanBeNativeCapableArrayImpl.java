/*
 * ObjectArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


public abstract class TypeCanBeNativeCapableArrayImpl extends TypeNativeObjectArrayImpl
{
    
    /** Creates a new instance of ObjectArrayType */
    public TypeCanBeNativeCapableArrayImpl(ClassTypeCanBeNativeCapableArrayImpl dataType)
    {
        super(dataType);
    }
    
    public TypeCanBeNativeCapableArrayImpl(ClassTypeCanBeNativeCapableArrayImpl dataType,TypeCanBeNativeCapableArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }  
    
    public TypeCanBeNativeCapableArrayImpl(ClassTypeCanBeNativeCapableArrayImpl dataType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType,varTypeComp);
    }

}
