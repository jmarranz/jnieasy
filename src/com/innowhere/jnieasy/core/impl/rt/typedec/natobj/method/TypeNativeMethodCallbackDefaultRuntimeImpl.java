/*
 * TypeNativeMethodCallbackDefaultRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:34
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeMethodRuntime;

public abstract class TypeNativeMethodCallbackDefaultRuntimeImpl extends TypeNativeCallbackDefaultRuntimeImpl implements TypeNativeMethodRuntime
{
    
    /**
     * Creates a new instance of TypeNativeMethodCallbackDefaultRuntimeImpl
     */
    public TypeNativeMethodCallbackDefaultRuntimeImpl(TypeNativeMethodCallbackDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeMethodSignature)signature;
    }
            
    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)signature;
    }
    
    public void setMethodSignature(NativeMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }    
}
