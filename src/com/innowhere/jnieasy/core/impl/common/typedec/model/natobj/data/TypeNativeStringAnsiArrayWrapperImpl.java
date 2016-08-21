/*
 * TypeNativeStringAnsiArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringAnsiArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.StringEncodingImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;

public class TypeNativeStringAnsiArrayWrapperImpl extends TypeNativeStringArrayWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeStringAnsiArrayWrapperImpl
     */
    public TypeNativeStringAnsiArrayWrapperImpl(ClassTypeNativeStringAnsiArrayWrapperImpl dataType)
    {
        super(dataType);

        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.ANSI_STR);
    }
                     
    public TypeNativeStringAnsiArrayWrapperImpl(ClassTypeNativeStringAnsiArrayWrapperImpl dataType,TypeNativeStringArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
        
        TypeNativeStringBasedInterface lastCompStrTypeDec = (TypeNativeStringBasedInterface)getTypeNativeArrayInfo().getLastComponentVarType().getTypeNative();
        lastCompStrTypeDec.setEncodingExpr(StringEncodingImpl.ANSI_STR);        
    }    
}

