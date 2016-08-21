/*
 * TypeNativeFieldMethodReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;

public abstract class TypeNativeFieldMethodReflectionWrapperImpl extends TypeNativeBehaviorReflectionWrapperImpl
{
    /** Creates a new instance of TypeNativeFieldMethodReflectionWrapperImpl */
    public TypeNativeFieldMethodReflectionWrapperImpl(ClassTypeNativeFieldMethodReflectionWrapperImpl dataType)
    {
        super(dataType); 
    }
 
    public TypeNativeFieldMethodReflectionWrapperImpl(ClassTypeNativeFieldMethodReflectionWrapperImpl dataType,TypeNativeFieldMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    } 
    
    public NativeFieldMethodSignatureImpl getFieldMethodSignature()
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }
    
    public void setFieldMethodSignature(NativeFieldMethodSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }     

}
