/*
 * TypeDLLMethodImpl.java
 *
 * Created on 1 de abril de 2005, 14:44
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeDLLMethodImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;


public abstract class TypeDLLMethodImpl extends TypeDLLBehaviorImpl
{
    
    /**
     * Creates a new instance of TypeDLLMethodImpl
     */
    public TypeDLLMethodImpl(ClassTypeDLLMethodImpl dataType)
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
