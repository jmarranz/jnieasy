/*
 * TypeNativeFieldMethodDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 14:44
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;


public abstract class TypeNativeFieldMethodDefaultImpl extends TypeNativeBehaviorDefaultImpl
{
    
    /**
     * Creates a new instance of TypeNativeFieldMethodDefaultImpl
     */
    public TypeNativeFieldMethodDefaultImpl(ClassTypeNativeFieldMethodDefaultImpl dataType)
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
