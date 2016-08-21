/*
 * TypeNativeMethodReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;

public abstract class TypeNativeMethodReflectionWrapperImpl extends TypeNativeBehaviorReflectionWrapperImpl
{
    /** Creates a new instance of TypeNativeMethodReflectionWrapperImpl */
    public TypeNativeMethodReflectionWrapperImpl(ClassTypeNativeMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }
            
    public TypeNativeMethodReflectionWrapperImpl(ClassTypeNativeMethodReflectionWrapperImpl dataType,TypeNativeMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }        
    
    public NativeMethodSignatureImpl getMethodSignature()
    {
        return (NativeMethodSignatureImpl)signature;
    }
    
    public void setMethodSignature(NativeMethodSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }    
}
