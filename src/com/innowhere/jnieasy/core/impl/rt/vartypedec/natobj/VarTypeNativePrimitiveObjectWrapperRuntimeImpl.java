/*
 * VarTypeNativePrimitiveObjectWrapperRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativePrimitiveObjectRuntimeImpl;


public class VarTypeNativePrimitiveObjectWrapperRuntimeImpl extends VarTypeCanBeNativeCapableWrapperRuntimeImpl
{
    /** Creates a new instance of VarTypeNativePrimitiveObjectWrapperRuntimeImpl */
    public VarTypeNativePrimitiveObjectWrapperRuntimeImpl(VarTypeNativePrimitiveObjectWrapperImpl varTypeDec,TypeNativePrimitiveObjectWrapperRuntimeImpl typeDecRt,
                VarTypeNativePrimitiveObjectRuntimeImpl wrappedVarType)
    {
        super(varTypeDec,typeDecRt,wrappedVarType);
    }
    
    public VarTypeNativePrimitiveObjectWrapperRuntimeImpl(VarTypeNativePrimitiveObjectWrapperImpl varTypeDec,TypeNativePrimitiveObjectWrapperRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt,new VarTypeNativePrimitiveObjectRuntimeImpl(varTypeDec.getVarTypeNativePrimitiveObject(), typeDecRt.getTypeNativePrimitiveObjectRuntime(), null));
    }  

}
