/*
 * VarTypeNativeArrayRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeArrayWrapperRuntimeImpl;

public class VarTypeNativeArrayRuntimeImpl extends VarTypeCanBeNativeCapableRuntimeImpl implements VarTypeNativeArrayRuntime
{
    /**
     * Creates a new instance of VarTypeNativeArrayRuntimeImpl
     */
    public VarTypeNativeArrayRuntimeImpl(VarTypeNativeArrayImpl varTypeDec,TypeNativeArrayRuntimeImpl typeDecRt,
                VarTypeNativeArrayWrapperRuntimeImpl wrapperVarType)
    {
        super(varTypeDec,typeDecRt,wrapperVarType);
    }
    
    public VarTypeNativeArrayRuntimeImpl(VarTypeNativeArrayImpl varTypeDec,TypeNativeArrayRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativeArrayWrapperRuntimeImpl(varTypeDec.getVarTypeNativeArrayWrapper(), typeDecRt.getTypeNativeArrayWrapperRuntime(),null));
    }

    public TypeNativeArrayRuntime getTypeNativeArrayRuntime()
    {
        return (TypeNativeArrayRuntime)typeRt;
    }

}
