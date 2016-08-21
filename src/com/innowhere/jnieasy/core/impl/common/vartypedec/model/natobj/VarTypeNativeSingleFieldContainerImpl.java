/*
 * VarTypeNativeSingleFieldContainerImpl.java
 *
 * Created on 7 de octubre de 2005, 12:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeSingleFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class VarTypeNativeSingleFieldContainerImpl extends VarTypeNativeFieldContainerImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeSingleFieldContainerImpl
     */
    public VarTypeNativeSingleFieldContainerImpl(TypeNativeSingleFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
}
