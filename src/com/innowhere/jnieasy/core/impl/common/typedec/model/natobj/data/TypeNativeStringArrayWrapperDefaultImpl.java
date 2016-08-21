/*
 * TypeNativeStringArrayImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;



public class TypeNativeStringArrayWrapperDefaultImpl extends TypeNativeStringArrayWrapperImpl
{

    /**
     * Creates a new instance of TypeNativeStringArrayImpl
     */
    public TypeNativeStringArrayWrapperDefaultImpl(ClassTypeNativeStringArrayWrapperDefaultImpl dataType)
    {
        super(dataType);
    }
                             
    public TypeNativeStringArrayWrapperDefaultImpl(ClassTypeNativeStringArrayWrapperDefaultImpl dataType,TypeNativeStringArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                         
    }    
}
