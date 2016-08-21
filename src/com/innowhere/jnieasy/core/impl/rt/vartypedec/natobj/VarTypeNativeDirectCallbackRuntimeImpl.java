/*
 * VarTypeNativeDirectCallbackRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeDirectCallbackImpl;

public class VarTypeNativeDirectCallbackRuntimeImpl extends VarTypeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeDirectCallbackRuntimeImpl
     */
    public VarTypeNativeDirectCallbackRuntimeImpl(VarTypeNativeDirectCallbackImpl varTypeDec,TypeNativeDirectCallbackRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
}
