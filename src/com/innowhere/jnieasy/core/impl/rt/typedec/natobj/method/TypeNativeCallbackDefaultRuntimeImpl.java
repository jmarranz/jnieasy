/*
 * TypeNativeCallbackDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBehaviorRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;

public abstract class TypeNativeCallbackDefaultRuntimeImpl extends TypeNativeCapableRuntimeImpl implements TypeNativeBehaviorRuntime
{
    protected NativeBehaviorSignatureRuntimeImpl signature;
    
    /**
     * Creates a new instance of TypeNativeCallbackDefaultRuntimeImpl
     */
    public TypeNativeCallbackDefaultRuntimeImpl(TypeNativeCallbackDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        return signature;
    }    
    
    public TypeNativeCallbackDefaultImpl getTypeNativeCallbackDefault()
    {
        return (TypeNativeCallbackDefaultImpl)typeDec;
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
        getTypeNativeCallbackDefault().setBehaviorSignature(this.signature.getBehaviorSignature());
    }
   
    
    public void checkValueNotNull(Object value)
    {    
        super.checkValueNotNull(value);
        
        NativeCallback methodObj = (NativeCallback)value;
        if (!getBehaviorSignature().equals(methodObj.getBehaviorSignature()))
            throw new JNIEasyException("Signature of method value is not compatible with declaration");
    }    
 
    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }      
}
