/*
 * TypeNativeObjectFieldContainerRuntimeImpl.java
 *
 * Created on 29 de septiembre de 2005, 18:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeObjectFieldContainerRuntimeImpl extends TypeNativeSingleFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeObjectFieldContainerRuntimeImpl
     */
    public TypeNativeObjectFieldContainerRuntimeImpl(TypeNativeObjectFieldContainerImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
}
