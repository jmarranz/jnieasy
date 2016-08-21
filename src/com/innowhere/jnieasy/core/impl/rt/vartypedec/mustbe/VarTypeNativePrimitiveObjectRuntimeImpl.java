/*
 * VarTypeNativePrimitiveObjectRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativePrimitiveObjectWrapperRuntimeImpl;

public class VarTypeNativePrimitiveObjectRuntimeImpl extends VarTypeCanBeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativePrimitiveObjectRuntimeImpl
     */
    public VarTypeNativePrimitiveObjectRuntimeImpl(VarTypeNativePrimitiveObjectImpl varTypeDec,TypeNativePrimitiveObjectRuntimeImpl typeDecRt,
                VarTypeNativePrimitiveObjectWrapperRuntimeImpl wrapperVarType)
    {
        super(varTypeDec,typeDecRt,wrapperVarType);
    }
    
    public VarTypeNativePrimitiveObjectRuntimeImpl(VarTypeNativePrimitiveObjectImpl varTypeDec,TypeNativePrimitiveObjectRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativePrimitiveObjectWrapperRuntimeImpl(varTypeDec.getVarTypeNativePrimitiveObjectWrapper(), typeDecRt.getTypeNativePrimitiveObjectWrapperRuntime(),null));
    }
     
}
