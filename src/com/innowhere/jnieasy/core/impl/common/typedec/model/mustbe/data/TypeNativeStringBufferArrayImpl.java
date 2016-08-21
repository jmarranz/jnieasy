/*
 * ClassTypeNativeStringBufferArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;



public class TypeNativeStringBufferArrayImpl extends TypeNativeStringBasedArrayImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeStringBufferArrayImpl
     */
    public TypeNativeStringBufferArrayImpl(ClassTypeNativeStringBufferArrayImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeStringBufferArrayImpl(ClassTypeNativeStringBufferArrayImpl dataType,TypeNativeStringBufferArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeStringBufferArrayImpl(ClassTypeNativeStringBufferArrayImpl dataType,VarTypeNativeImpl varTypeDecComp)
    {
        super(dataType,varTypeDecComp);
    }
    
}
