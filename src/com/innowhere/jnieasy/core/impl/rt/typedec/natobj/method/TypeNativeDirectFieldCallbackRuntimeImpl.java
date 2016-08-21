/*
 * TypeNativeDirectFieldCallbackRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:48
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFieldMethodRuntime;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;


public abstract class TypeNativeDirectFieldCallbackRuntimeImpl extends TypeNativeDirectCallbackRuntimeImpl implements TypeNativeFieldMethodRuntime
{
    
    /**
     * Creates a new instance of TypeNativeDirectFieldCallbackRuntimeImpl
     */
    public TypeNativeDirectFieldCallbackRuntimeImpl(TypeNativeDirectFieldCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();        
    }

    public void setFieldMethodSignature(NativeFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);        
    }
}
