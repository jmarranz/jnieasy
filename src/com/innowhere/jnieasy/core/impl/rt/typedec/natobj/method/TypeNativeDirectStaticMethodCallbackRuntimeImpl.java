/*
 * TypeNativeDirectStaticMethodCallbackRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticMethodRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectStaticMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.NativeStaticMethodSignature;


public class TypeNativeDirectStaticMethodCallbackRuntimeImpl extends TypeNativeDirectMethodCallbackRuntimeImpl implements TypeNativeStaticMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeDirectStaticMethodCallbackRuntimeImpl
     */
    public TypeNativeDirectStaticMethodCallbackRuntimeImpl(TypeNativeDirectStaticMethodCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }

    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)getBehaviorSignature();
    }
    
    public void setStaticMethodSignature(NativeStaticMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
