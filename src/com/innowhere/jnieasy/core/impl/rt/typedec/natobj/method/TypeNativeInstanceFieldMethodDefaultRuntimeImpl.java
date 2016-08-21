/*
 * TypeNativeInstanceFieldMethodDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceFieldMethodRuntime;

public class TypeNativeInstanceFieldMethodDefaultRuntimeImpl extends TypeNativeFieldMethodDefaultRuntimeImpl implements TypeNativeInstanceFieldMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeInstanceFieldMethodDefaultRuntimeImpl
     */
    public TypeNativeInstanceFieldMethodDefaultRuntimeImpl(TypeNativeInstanceFieldMethodDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
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
