/*
 * TypeNativeObjectArrayWrapperDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeObjectArrayDefaultImpl;

public class TypeNativeObjectArrayWrapperDefaultImpl extends TypeNativeObjectArrayWrapperImpl
{

    /**
     * Creates a new instance of TypeNativeObjectArrayWrapperDefaultImpl
     */
    public TypeNativeObjectArrayWrapperDefaultImpl(ClassTypeNativeObjectArrayWrapperDefaultImpl dataType)
    {
        super(dataType);
    }
                         
    public TypeNativeObjectArrayWrapperDefaultImpl(ClassTypeNativeObjectArrayWrapperDefaultImpl dataType,TypeNativeObjectArrayDefaultImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);      
    }       
}
