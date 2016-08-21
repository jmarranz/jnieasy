/*
 * TypeNativeStringBufferUnicodeArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferUnicodeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.StringEncodingImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;

public class TypeNativeStringBufferUnicodeArrayWrapperImpl extends TypeNativeStringBufferArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeStringBufferUnicodeArrayWrapperImpl
     */
    public TypeNativeStringBufferUnicodeArrayWrapperImpl(ClassTypeNativeStringBufferUnicodeArrayWrapperImpl dataType)
    {
        super(dataType);

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.UNICODE_STR);        
    }
                     
    public TypeNativeStringBufferUnicodeArrayWrapperImpl(ClassTypeNativeStringBufferUnicodeArrayWrapperImpl dataType,TypeNativeStringBufferArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);   

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.UNICODE_STR);        
    }        
}

