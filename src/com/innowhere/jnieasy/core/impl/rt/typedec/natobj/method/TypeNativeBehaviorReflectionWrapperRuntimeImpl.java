/*
 * TypeNativeBehaviorReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBehaviorReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.method.NativeBehaviorReflection;



public abstract class TypeNativeBehaviorReflectionWrapperRuntimeImpl extends TypeNativeMemberReflectionWrapperRuntimeImpl implements TypeNativeBehaviorReflectionRuntime
{
    protected NativeBehaviorSignatureRuntimeImpl signature;
    
    /** Creates a new instance of TypeNativeBehaviorReflectionWrapperRuntimeImpl */
    public TypeNativeBehaviorReflectionWrapperRuntimeImpl(TypeNativeBehaviorReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        return signature;
    }
    
    public TypeNativeBehaviorReflectionWrapperImpl getTypeNativeBehaviorReflectionWrapper()
    {
        return (TypeNativeBehaviorReflectionWrapperImpl)typeDec;
    }
    
    public abstract NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature);
    
    public void setBehaviorSignature(NativeBehaviorSignature signature)
    {
        if (rtMgr.getNativeManager().isRuntimeChecking())
        {
            if (signature == null) throw new JNIEasyException("Behavior signature cannot be null");
            checkSignature(signature);
        }
        
        this.signature = (NativeBehaviorSignatureRuntimeImpl)signature;
        getTypeNativeBehaviorReflectionWrapper().setBehaviorSignature(this.signature.getBehaviorSignature());
    }
    
    public void checkValueNotNull(Object value)
    {    
        super.checkValueNotNull(value);
        
        NativeBehaviorReflection methodObj = (NativeBehaviorReflection)value;
        if (!getBehaviorSignature().equals(methodObj.getBehaviorSignature()))
            throw new JNIEasyException("Signature of method value is not compatible with declaration");
    }        

    
    
}
