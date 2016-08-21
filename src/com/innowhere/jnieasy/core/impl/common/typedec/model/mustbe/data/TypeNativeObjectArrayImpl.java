/*
 * TypeNativeObjectArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


public abstract class TypeNativeObjectArrayImpl extends TypeNativeArrayImpl
{
    
    /**
     * Creates a new instance of TypeNativeObjectArrayImpl
     */

    public TypeNativeObjectArrayImpl(ClassTypeNativeObjectArrayImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeObjectArrayImpl(ClassTypeNativeObjectArrayImpl dataType,TypeNativeObjectArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }   
    
    public TypeNativeObjectArrayImpl(ClassTypeNativeObjectArrayImpl dataType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType,varTypeComp);
    }

}
