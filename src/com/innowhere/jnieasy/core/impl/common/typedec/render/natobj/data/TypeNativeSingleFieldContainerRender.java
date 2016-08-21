/*
 * TypeNativeSingleFieldContainerRender.java
 *
 * Created on 7 de octubre de 2005, 12:27
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeSingleFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeSingleFieldContainerRender extends TypeNativeFieldContainerRender
{
    
    /**
     * Creates a new instance of TypeNativeSingleFieldContainerRender
     */
    public TypeNativeSingleFieldContainerRender(TypeNativeSingleFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
}
