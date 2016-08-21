/*
 * TypeNativeDirectInstanceFieldCallbackRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceFieldMethodRuntime;
import com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature;


public class TypeNativeDirectInstanceFieldCallbackRuntimeImpl extends TypeNativeDirectFieldCallbackRuntimeImpl implements TypeNativeInstanceFieldMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeDirectInstanceFieldCallbackRuntimeImpl
     */
    public TypeNativeDirectInstanceFieldCallbackRuntimeImpl(TypeNativeDirectInstanceFieldCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)getBehaviorSignature();
    }
    
    public void setInstanceFieldMethodSignature(NativeInstanceFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }    
}
