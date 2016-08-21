/*
 * VarTypeDLLBehaviorRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeDLLBehaviorRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeDLLBehaviorImpl;

public class VarTypeDLLBehaviorRuntimeImpl extends VarTypeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeDLLBehaviorRuntimeImpl
     */
    public VarTypeDLLBehaviorRuntimeImpl(VarTypeDLLBehaviorImpl varTypeDec,TypeDLLBehaviorRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
}
