/*
 * TypeNativeSingleFieldContainerRuntimeImpl.java
 *
 * Created on 7 de octubre de 2005, 12:46
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeSingleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeSingleFieldContainerRuntimeImpl extends TypeNativeFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeSingleFieldContainerRuntimeImpl
     */
    public TypeNativeSingleFieldContainerRuntimeImpl(TypeNativeSingleFieldContainerImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
}
