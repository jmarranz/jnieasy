/*
 * TypeNativeStaticMethodDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticMethodRuntime;



public class TypeNativeStaticMethodDefaultRuntimeImpl extends TypeNativeMethodDefaultRuntimeImpl implements TypeNativeStaticMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeStaticMethodDefaultRuntimeImpl
     */
    public TypeNativeStaticMethodDefaultRuntimeImpl(TypeNativeStaticMethodDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
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
