/*
 * TypeNativeInstanceFieldCallbackDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceFieldCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceFieldMethodRuntime;

public class TypeNativeInstanceFieldCallbackDefaultRuntimeImpl extends TypeNativeFieldCallbackDefaultRuntimeImpl implements TypeNativeInstanceFieldMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeInstanceFieldCallbackDefaultRuntimeImpl
     */
    public TypeNativeInstanceFieldCallbackDefaultRuntimeImpl(TypeNativeInstanceFieldCallbackDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeInstanceFieldMethodSignature)signature;
    }
    
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)signature;
    }
    
    public void setInstanceFieldMethodSignature(NativeInstanceFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }   

}
