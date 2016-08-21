/*
 * TypeCPPConstructorRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;

import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeConstructorRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeCPPConstructorImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public class TypeCPPConstructorRuntimeImpl extends TypeDLLBehaviorRuntimeImpl implements TypeNativeConstructorRuntime
{
    /**
     * Creates a new instance of TypeCPPConstructorRuntimeImpl
     */
    public TypeCPPConstructorRuntimeImpl(TypeCPPConstructorImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeConstructorSignature)signature;
    }
    
    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)signature;
    }
    
    public void setConstructorSignature(NativeConstructorSignature signature)
    {
        setBehaviorSignature(signature);
    }
    
}
