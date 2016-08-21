/*
 * VarTypeNativeMemberReflectionWrapperRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeMemberReflectionWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativeMemberReflectionRuntimeImpl;


public class VarTypeNativeMemberReflectionWrapperRuntimeImpl extends VarTypeCanBeNativeCapableWrapperRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeMemberReflectionWrapperRuntimeImpl
     */
    public VarTypeNativeMemberReflectionWrapperRuntimeImpl(VarTypeNativeMemberReflectionWrapperImpl varTypeDec,TypeNativeMemberReflectionWrapperRuntimeImpl typeDecRt,
                VarTypeNativeMemberReflectionRuntimeImpl wrappedVarType)
    {
        super(varTypeDec,typeDecRt,wrappedVarType);
    }
    
    public VarTypeNativeMemberReflectionWrapperRuntimeImpl(VarTypeNativeMemberReflectionWrapperImpl varTypeDec,TypeNativeMemberReflectionWrapperRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativeMemberReflectionRuntimeImpl(varTypeDec.getVarTypeNativeMemberReflection(), typeDecRt.getTypeNativeMemberReflectionRuntime(), null));
    } 

}
