/*
 * TypeNativeFieldMethodDefaultRuntimeImpl.java
 *
 * Created on 1 de abril de 2005, 14:34
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFieldMethodRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeBehaviorDefaultRuntimeImpl;

public abstract class TypeNativeFieldMethodDefaultRuntimeImpl extends TypeNativeBehaviorDefaultRuntimeImpl implements TypeNativeFieldMethodRuntime
{
    
    /**
     * Creates a new instance of TypeNativeFieldMethodDefaultRuntimeImpl
     */
    public TypeNativeFieldMethodDefaultRuntimeImpl(TypeNativeFieldMethodDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
        
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)signature;
    }
    
    public void setFieldMethodSignature(NativeFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }    
}
