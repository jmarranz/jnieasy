/*
 * VarTypeNativeMultipleFieldContainerRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeMultipleFieldContainerImpl;

public class VarTypeNativeMultipleFieldContainerRuntimeImpl extends VarTypeNativeFieldContainerRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeMultipleFieldContainerRuntimeImpl
     */
    public VarTypeNativeMultipleFieldContainerRuntimeImpl(VarTypeNativeMultipleFieldContainerImpl varTypeDec,TypeNativeMultipleFieldContainerRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
}
