/*
 * TypeNativeMethodDefaultRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:34
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeMethodRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeBehaviorDefaultRuntimeImpl;


public abstract class TypeNativeMethodDefaultRuntimeImpl extends TypeNativeBehaviorDefaultRuntimeImpl implements TypeNativeMethodRuntime
{
    
    /**
     * Creates a new instance of TypeNativeMethodDefaultRuntimeImpl
     */
    public TypeNativeMethodDefaultRuntimeImpl(TypeNativeMethodDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
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
