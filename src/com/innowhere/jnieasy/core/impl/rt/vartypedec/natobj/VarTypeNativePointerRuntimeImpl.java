/*
 * VarTypeNativePointerRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePointerImpl;

public class VarTypeNativePointerRuntimeImpl extends VarTypeNativeFieldContainerRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativePointerRuntimeImpl
     */
    public VarTypeNativePointerRuntimeImpl(VarTypeNativePointerImpl varTypeDec,TypeNativePointerRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
}
