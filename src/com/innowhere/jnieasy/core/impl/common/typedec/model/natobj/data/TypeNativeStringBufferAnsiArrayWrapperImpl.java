/*
 * TypeNativeStringBufferAnsiArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferAnsiArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.StringEncodingImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;

public class TypeNativeStringBufferAnsiArrayWrapperImpl extends TypeNativeStringBufferArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeStringBufferAnsiArrayWrapperImpl
     */
    public TypeNativeStringBufferAnsiArrayWrapperImpl(ClassTypeNativeStringBufferAnsiArrayWrapperImpl dataType)
    {
        super(dataType);

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.ANSI_STR);
    }    
                             
    public TypeNativeStringBufferAnsiArrayWrapperImpl(ClassTypeNativeStringBufferAnsiArrayWrapperImpl dataType,TypeNativeStringBufferArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.ANSI_STR);        
    }    
}

