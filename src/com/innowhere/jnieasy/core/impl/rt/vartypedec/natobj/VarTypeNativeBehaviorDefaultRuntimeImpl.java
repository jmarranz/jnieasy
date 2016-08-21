/*
 * VarTypeNativeBehaviorDefaultRuntimeImpl.java
 *
 * Created on 21 de septiembre de 2005, 13:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeBehaviorDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeBehaviorDefaultRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class VarTypeNativeBehaviorDefaultRuntimeImpl extends VarTypeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeBehaviorDefaultRuntimeImpl
     */
    public VarTypeNativeBehaviorDefaultRuntimeImpl(VarTypeNativeBehaviorDefaultImpl varTypeDec,TypeNativeBehaviorDefaultRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
    
}
