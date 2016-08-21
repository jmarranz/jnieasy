/*
 * VarTypeNativeArrayWrapperRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativeArrayRuntimeImpl;

public class VarTypeNativeArrayWrapperRuntimeImpl extends VarTypeCanBeNativeCapableWrapperRuntimeImpl implements VarTypeNativeArrayRuntime
{
    /** Creates a new instance of VarTypeNativeArrayWrapperRuntimeImpl */
    public VarTypeNativeArrayWrapperRuntimeImpl(VarTypeNativeArrayWrapperImpl varTypeDec,TypeNativeArrayWrapperRuntimeImpl typeDecRt,
                VarTypeNativeArrayRuntimeImpl wrappedVarType)
    {
        super(varTypeDec,typeDecRt,wrappedVarType);
    }
    
    public VarTypeNativeArrayWrapperRuntimeImpl(VarTypeNativeArrayWrapperImpl varTypeDec,TypeNativeArrayWrapperRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativeArrayRuntimeImpl(varTypeDec.getVarTypeNativeArray(), typeDecRt.getTypeNativeArrayRuntime(), null));
    }    
    
    public TypeNativeArrayRuntime getTypeNativeArrayRuntime()
    {
        return (TypeNativeArrayRuntime)typeRt;
    }
 
}
