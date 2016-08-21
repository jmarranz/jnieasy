/*
 * TypeCMethodRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticMethodRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeCMethodImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class TypeCMethodRuntimeImpl extends TypeDLLMethodRuntimeImpl implements TypeNativeStaticMethodRuntime
{
    /**
     * Creates a new instance of TypeCMethodRuntimeImpl
     */
    public TypeCMethodRuntimeImpl(TypeCMethodImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeStaticMethodSignature)signature;
    }
    
    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)signature;
    }
    
    public void setStaticMethodSignature(NativeStaticMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
