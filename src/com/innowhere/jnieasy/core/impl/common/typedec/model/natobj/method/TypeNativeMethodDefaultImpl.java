/*
 * TypeNativeMethodDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 14:44
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;


public abstract class TypeNativeMethodDefaultImpl extends TypeNativeBehaviorDefaultImpl
{
    
    /**
     * Creates a new instance of TypeNativeMethodDefaultImpl
     */
    public TypeNativeMethodDefaultImpl(ClassTypeNativeMethodDefaultImpl dataType)
    {
        super(dataType);
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
