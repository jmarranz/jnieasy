/*
 * VarTypeNativeStringBasedRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringBasedRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeStringBasedWrapperRuntimeImpl;


public class VarTypeNativeStringBasedRuntimeImpl extends VarTypeCanBeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeStringBasedRuntimeImpl
     */
    public VarTypeNativeStringBasedRuntimeImpl(VarTypeNativeStringBasedImpl varTypeDec,TypeNativeStringBasedRuntimeImpl typeDecRt,
                VarTypeNativeStringBasedWrapperRuntimeImpl wrapperVarType)
    {
        super(varTypeDec,typeDecRt,wrapperVarType);
    }
    
    public VarTypeNativeStringBasedRuntimeImpl(VarTypeNativeStringBasedImpl varTypeDec,TypeNativeStringBasedRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativeStringBasedWrapperRuntimeImpl(varTypeDec.getVarTypeNativeStringBasedWrapper(), typeDecRt.getTypeNativeStringBasedWrapperRuntime(),null));
    }
     
}
