/*
 * TypeNativeInstanceMethodDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceMethodRuntime;

public class TypeNativeInstanceMethodDefaultRuntimeImpl extends TypeNativeMethodDefaultRuntimeImpl implements TypeNativeInstanceMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeInstanceMethodDefaultRuntimeImpl
     */
    public TypeNativeInstanceMethodDefaultRuntimeImpl(TypeNativeInstanceMethodDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
            
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeInstanceMethodSignature)signature;
    }
            
    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)signature;
    }
    
    public void setInstanceMethodSignature(NativeInstanceMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }   

}
