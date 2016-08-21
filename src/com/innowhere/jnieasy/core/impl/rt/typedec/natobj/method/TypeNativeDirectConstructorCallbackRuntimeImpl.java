/*
 * TypeNativeDirectConstructorCallbackRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeConstructorRuntime;
import com.innowhere.jnieasy.core.typedec.NativeConstructorSignature;

public class TypeNativeDirectConstructorCallbackRuntimeImpl extends TypeNativeDirectCallbackRuntimeImpl implements TypeNativeConstructorRuntime
{
    /**
     * Creates a new instance of TypeNativeDirectConstructorCallbackRuntimeImpl
     */
    public TypeNativeDirectConstructorCallbackRuntimeImpl(TypeNativeDirectConstructorCallbackImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }

    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)getBehaviorSignature();
    }

    public void setConstructorSignature(NativeConstructorSignature signature)
    {
        setBehaviorSignature(signature);
    }
}
