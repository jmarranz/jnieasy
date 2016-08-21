/*
 * VarTypeNativeMemberReflectionRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeMemberReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeMemberReflectionWrapperRuntimeImpl;

public class VarTypeNativeMemberReflectionRuntimeImpl extends VarTypeCanBeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeMemberReflectionRuntimeImpl
     */
    public VarTypeNativeMemberReflectionRuntimeImpl(VarTypeNativeMemberReflectionImpl varTypeDec,TypeNativeMemberReflectionRuntimeImpl typeDecRt,
                VarTypeNativeMemberReflectionWrapperRuntimeImpl wrapperVarType)
    {
        super(varTypeDec,typeDecRt,wrapperVarType);
    }
    
    public VarTypeNativeMemberReflectionRuntimeImpl(VarTypeNativeMemberReflectionImpl varTypeDec,TypeNativeMemberReflectionRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativeMemberReflectionWrapperRuntimeImpl(varTypeDec.getVarTypeNativeMemberReflectionWrapper(), typeDecRt.getTypeNativeMemberWrapperRuntime(),null));
    }
     
}
