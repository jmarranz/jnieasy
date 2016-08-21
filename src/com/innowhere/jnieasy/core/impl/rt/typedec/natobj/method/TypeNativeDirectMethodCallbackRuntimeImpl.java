/*
 * TypeNativeDirectMethodCallbackRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:48
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeMethodRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;


public abstract class TypeNativeDirectMethodCallbackRuntimeImpl extends TypeNativeDirectCallbackRuntimeImpl implements TypeNativeMethodRuntime
{
    
    /**
     * Creates a new instance of TypeNativeDirectMethodCallbackRuntimeImpl
     */
    public TypeNativeDirectMethodCallbackRuntimeImpl(TypeNativeDirectMethodCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }

    public void setMethodSignature(NativeMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)getBehaviorSignature();
    }

}
