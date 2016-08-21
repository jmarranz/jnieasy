/*
 * VarTypeNativePrimitiveWrapperRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePrimitiveWrapperImpl;

public class VarTypeNativePrimitiveWrapperRuntimeImpl extends VarTypeNativeFieldContainerRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativePrimitiveWrapperRuntimeImpl
     */
    public VarTypeNativePrimitiveWrapperRuntimeImpl(VarTypeNativePrimitiveWrapperImpl varTypeDec,TypeNativePrimitiveWrapperRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
}
