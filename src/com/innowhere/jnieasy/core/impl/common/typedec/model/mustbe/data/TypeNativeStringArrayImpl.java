/*
 * ClassTypeNativeStringArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;



public class TypeNativeStringArrayImpl extends TypeNativeStringBasedArrayImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeStringArrayImpl
     */
    public TypeNativeStringArrayImpl(ClassTypeNativeStringArrayImpl dataType)
    {
        super(dataType);
    }
     
    public TypeNativeStringArrayImpl(ClassTypeNativeStringArrayImpl dataType,TypeNativeStringArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeStringArrayImpl(ClassTypeNativeStringArrayImpl dataType,VarTypeNativeImpl varTypeDecComp)
    {
        super(dataType,varTypeDecComp);
    }

}
