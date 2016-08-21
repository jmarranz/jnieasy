/*
 * TypeNativeStaticMethodCallbackDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticMethodCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticMethodRuntime;



public class TypeNativeStaticMethodCallbackDefaultRuntimeImpl extends TypeNativeMethodCallbackDefaultRuntimeImpl implements TypeNativeStaticMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeStaticMethodCallbackDefaultRuntimeImpl
     */
    public TypeNativeStaticMethodCallbackDefaultRuntimeImpl(TypeNativeStaticMethodCallbackDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
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
