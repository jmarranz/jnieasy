/*
 * TypeNativeDirectStaticFieldCallbackRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectStaticFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticFieldMethodRuntime;
import com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature;


public class TypeNativeDirectStaticFieldCallbackRuntimeImpl extends TypeNativeDirectFieldCallbackRuntimeImpl implements TypeNativeStaticFieldMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeDirectStaticFieldCallbackRuntimeImpl
     */
    public TypeNativeDirectStaticFieldCallbackRuntimeImpl(TypeNativeDirectStaticFieldCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }

    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)getBehaviorSignature();
    }   

    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
