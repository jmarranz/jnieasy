/*
 * TypeNativeObjectImpl.java
 *
 * Created on 2 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;

public abstract class TypeNativeObjectImpl extends TypeNativeImpl implements TypeNativeObjectInterface
{
    
    /**
     * Creates a new instance of TypeNativeObjectImpl
     */
    public TypeNativeObjectImpl(ClassTypeNativeObjectImpl dataType)
    {
        super(dataType);
    }
  
}
