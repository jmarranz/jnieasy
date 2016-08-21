/*
 * TypeNativeStringBufferArrayWrapperDefaultImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;



public class TypeNativeStringBufferArrayWrapperDefaultImpl extends TypeNativeStringBufferArrayWrapperImpl
{

    /** Creates a new instance of TypeNativeStringBufferArrayWrapperDefaultImpl */
    public TypeNativeStringBufferArrayWrapperDefaultImpl(ClassTypeNativeStringBufferArrayWrapperImpl dataType)
    {
        super(dataType);
    }
                         
    public TypeNativeStringBufferArrayWrapperDefaultImpl(ClassTypeNativeStringBufferArrayWrapperImpl dataType,TypeNativeStringBufferArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                         
    }             
}
