/*
 * TypeNativeConstructorCallbackDefaultRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeConstructorRuntime;

public class TypeNativeConstructorCallbackDefaultRuntimeImpl extends TypeNativeCallbackDefaultRuntimeImpl implements TypeNativeConstructorRuntime
{
    /** Creates a new instance of TypeNativeConstructorCallbackDefaultRuntimeImpl */
    public TypeNativeConstructorCallbackDefaultRuntimeImpl(TypeNativeConstructorCallbackDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
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
