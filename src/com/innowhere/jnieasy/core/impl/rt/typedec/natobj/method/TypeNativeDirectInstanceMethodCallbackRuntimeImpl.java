/*
 * TypeNativeDirectInstanceMethodCallbackRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectInstanceMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceMethodRuntime;
import com.innowhere.jnieasy.core.typedec.NativeInstanceMethodSignature;


public class TypeNativeDirectInstanceMethodCallbackRuntimeImpl extends TypeNativeDirectMethodCallbackRuntimeImpl implements TypeNativeInstanceMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeDirectInstanceMethodCallbackRuntimeImpl
     */
    public TypeNativeDirectInstanceMethodCallbackRuntimeImpl(TypeNativeDirectInstanceMethodCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }

    public void setInstanceMethodSignature(NativeInstanceMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)getBehaviorSignature();
    }
    
    
}
