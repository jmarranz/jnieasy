/*
 * TypeNativeMethodCallbackDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 14:44
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMethodCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;


public abstract class TypeNativeMethodCallbackDefaultImpl extends TypeNativeCallbackDefaultImpl
{
    
    /**
     * Creates a new instance of TypeNativeMethodCallbackDefaultImpl
     */
    public TypeNativeMethodCallbackDefaultImpl(ClassTypeNativeMethodCallbackDefaultImpl dataType)
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
