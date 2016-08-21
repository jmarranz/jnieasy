/*
 * TypeNativeNumberImpl.java
 *
 * Created on 3 de febrero de 2005, 11:19
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeNumberImpl;

public abstract class TypeNativeNumberImpl extends TypeNativePrimitiveImpl
{
   
    /**
     * Creates a new instance of TypeNativeNumberImpl
     */
    public TypeNativeNumberImpl(ClassTypeNativeNumberImpl dataType)
    {
        super(dataType);
    }
}
