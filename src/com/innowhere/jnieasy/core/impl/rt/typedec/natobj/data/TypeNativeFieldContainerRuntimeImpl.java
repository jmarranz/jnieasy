/*
 * TypeNativeFieldContainerRuntimeImpl.java
 *
 * Created on 14 de septiembre de 2005, 12:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeFieldContainerRuntimeImpl extends TypeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeFieldContainerRuntimeImpl
     */
    public TypeNativeFieldContainerRuntimeImpl(TypeNativeFieldContainerImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
}
