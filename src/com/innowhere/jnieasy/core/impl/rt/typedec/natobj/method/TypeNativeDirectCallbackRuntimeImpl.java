/*
 * TypeNativeDirectCallbackRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBehaviorRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectCallback;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature;

public abstract class TypeNativeDirectCallbackRuntimeImpl extends TypeNativeCapableRuntimeImpl implements TypeNativeBehaviorRuntime
{
    protected NativeBehaviorSignatureRuntimeImpl signature;
    
    /**
     * Creates a new instance of TypeNativeDirectCallbackRuntimeImpl
     */
    public TypeNativeDirectCallbackRuntimeImpl(TypeNativeDirectCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }    

    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }    

    public TypeNativeDirectCallbackImpl getTypeNativeDirectCallback()
    {
        return (TypeNativeDirectCallbackImpl)typeDec;
    }
    
    public NativeBehaviorSignatureRuntimeImpl getDefaultBehaviorSignatureRuntime()
    {
        ClassTypeNativeDirectCallbackRuntimeImpl classTypeRt = (ClassTypeNativeDirectCallbackRuntimeImpl)getClassTypeRuntime();
        JavaClassAsNativeDirectCallbackRuntimeImpl javaClassDesc = (JavaClassAsNativeDirectCallbackRuntimeImpl)classTypeRt.getJavaClassAsNativeCapableRuntime();
        return javaClassDesc.getBehaviorSignatureRuntime();                
    }    
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        TypeNativeDirectCallbackImpl typeDec = getTypeNativeDirectCallback();
        if ((signature == null)&& typeDec.isCustom())
            return getDefaultBehaviorSignatureRuntime();
        else
            return signature;
    }   

    public void setBehaviorSignature(NativeBehaviorSignature signature)
    {
        this.signature = (NativeBehaviorSignatureRuntimeImpl)signature;
        TypeNativeDirectCallbackImpl typeDec = getTypeNativeDirectCallback();        
        typeDec.setBehaviorSignature(this.signature.getBehaviorSignature());
    }
    
    public void checkValueNotNull(Object value)
    {    
        super.checkValueNotNull(value);
        
        NativeDirectCallback methodObj = (NativeDirectCallback)value;
        // No usar this.signature directamente pues el método getBehaviorSignature está sobrecargado
        if (!getBehaviorSignature().equals(methodObj.getBehaviorSignature()))
            throw new JNIEasyException("Signature of method value is not compatible with declaration");
    }    
}
