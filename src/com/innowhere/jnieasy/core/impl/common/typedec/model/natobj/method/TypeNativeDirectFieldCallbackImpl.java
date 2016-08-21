/*
 * TypeNativeDirectFieldCallbackImpl.java
 *
 * Created on 1 de abril de 2005, 14:37
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;



public abstract class TypeNativeDirectFieldCallbackImpl extends TypeNativeDirectCallbackImpl
{
    
    /**
     * Creates a new instance of TypeNativeDirectFieldCallbackImpl
     */
    public TypeNativeDirectFieldCallbackImpl(ClassTypeNativeDirectFieldCallbackImpl dataType)
    {
        super(dataType);
    }
}
