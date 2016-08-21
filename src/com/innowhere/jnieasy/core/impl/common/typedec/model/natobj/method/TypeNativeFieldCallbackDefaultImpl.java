/*
 * TypeNativeFieldCallbackDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 14:44
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeFieldCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;


public abstract class TypeNativeFieldCallbackDefaultImpl extends TypeNativeCallbackDefaultImpl
{
    
    /**
     * Creates a new instance of TypeNativeFieldCallbackDefaultImpl
     */
    public TypeNativeFieldCallbackDefaultImpl(ClassTypeNativeFieldCallbackDefaultImpl dataType)
    {
        super(dataType);
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
