/*
 * TypeDLLBehaviorRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeDLLBehaviorImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBehaviorRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;

public abstract class TypeDLLBehaviorRuntimeImpl extends TypeNativeCapableRuntimeImpl implements TypeNativeBehaviorRuntime
{
    protected NativeBehaviorSignatureRuntimeImpl signature;
    
    /**
     * Creates a new instance of TypeDLLBehaviorRuntimeImpl
     */
    public TypeDLLBehaviorRuntimeImpl(TypeDLLBehaviorImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        return signature;
    }    
    
    public TypeDLLBehaviorImpl getTypeDLLBehavior()
    {
        return (TypeDLLBehaviorImpl)typeDec;
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
        getTypeDLLBehavior().setBehaviorSignature(this.signature.getBehaviorSignature());
    }
   
    
    public void checkValueNotNull(Object value)
    {    
        super.checkValueNotNull(value);
        
        DLLBehavior methodObj = (DLLBehavior)value;
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
