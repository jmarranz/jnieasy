/*
 * TypeNativeStringUnicodeArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringUnicodeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.StringEncodingImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;
import com.innowhere.jnieasy.core.typedec.StringEncoding;


public class TypeNativeStringUnicodeArrayWrapperImpl extends TypeNativeStringArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeStringUnicodeArrayWrapperImpl
     */
    public TypeNativeStringUnicodeArrayWrapperImpl(ClassTypeNativeStringUnicodeArrayWrapperImpl dataType)
    {
        super(dataType);

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.UNICODE_STR);
    }
                     
    public TypeNativeStringUnicodeArrayWrapperImpl(ClassTypeNativeStringUnicodeArrayWrapperImpl dataType,TypeNativeStringArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                  

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.UNICODE_STR);        
    }           
}

