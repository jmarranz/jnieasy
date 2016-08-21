/*
 * TypeNativeCapableImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectImpl;



public abstract class TypeNativeCapableImpl extends TypeNativeObjectImpl
{
   
    /**
     * Creates a new instance of TypeNativeCapableImpl
     */
    public TypeNativeCapableImpl(ClassTypeNativeCapableImpl dataType)
    {
        super(dataType);
    }
    
    public ClassTypeNativeCapableImpl getClassTypeNativeCapable()
    {
        return (ClassTypeNativeCapableImpl)dataType;
    }
}
