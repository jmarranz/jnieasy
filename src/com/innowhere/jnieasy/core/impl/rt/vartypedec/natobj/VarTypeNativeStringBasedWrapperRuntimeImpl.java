/*
 * VarTypeNativeStringBasedWrapperRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBasedWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativeStringBasedRuntimeImpl;


public class VarTypeNativeStringBasedWrapperRuntimeImpl extends VarTypeCanBeNativeCapableWrapperRuntimeImpl
{
    /** Creates a new instance of VarTypeNativeStringBasedWrapperRuntimeImpl */
    public VarTypeNativeStringBasedWrapperRuntimeImpl(VarTypeNativeStringBasedWrapperImpl varTypeDec,TypeNativeStringBasedWrapperRuntimeImpl typeDecRt,
                VarTypeNativeStringBasedRuntimeImpl wrappedVarType)
    {
        super(varTypeDec,typeDecRt,wrappedVarType);
    }
    
    public VarTypeNativeStringBasedWrapperRuntimeImpl(VarTypeNativeStringBasedWrapperImpl varTypeDec,TypeNativeStringBasedWrapperRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativeStringBasedRuntimeImpl(varTypeDec.getVarTypeNativeStringBased(), typeDecRt.getTypeNativeStringBasedRuntime(), null));
    }
    
}
