/*
 * VarTypeNativeCapableDefaultRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeCapableDefaultImpl;

public class VarTypeNativeCapableDefaultRuntimeImpl extends VarTypeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeCapableDefaultRuntimeImpl
     */
    public VarTypeNativeCapableDefaultRuntimeImpl(VarTypeNativeCapableDefaultImpl varTypeDec,TypeNativeCapableDefaultRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
}
