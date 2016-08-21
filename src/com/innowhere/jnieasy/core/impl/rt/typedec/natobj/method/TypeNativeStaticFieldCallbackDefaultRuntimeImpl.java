/*
 * TypeNativeStaticFieldCallbackDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticFieldCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticFieldMethodRuntime;


public class TypeNativeStaticFieldCallbackDefaultRuntimeImpl extends TypeNativeFieldCallbackDefaultRuntimeImpl implements TypeNativeStaticFieldMethodRuntime
{
    /**
     * Creates a new instance of TypeNativeStaticFieldCallbackDefaultRuntimeImpl
     */
    public TypeNativeStaticFieldCallbackDefaultRuntimeImpl(TypeNativeStaticFieldCallbackDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeStaticFieldMethodSignature)signature;
    }
    
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)signature;
    }
    
    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
