/*
 * VarTypeNativeFieldContainerRuntimeImpl.java
 *
 * Created on 14 de septiembre de 2005, 12:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;

import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeFieldContainerRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class VarTypeNativeFieldContainerRuntimeImpl extends VarTypeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeFieldContainerRuntimeImpl
     */
    public VarTypeNativeFieldContainerRuntimeImpl(VarTypeNativeFieldContainerImpl varTypeDec,TypeNativeFieldContainerRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
    
}
