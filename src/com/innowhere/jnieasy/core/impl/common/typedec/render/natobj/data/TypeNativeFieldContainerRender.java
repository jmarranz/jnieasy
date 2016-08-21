/*
 * TypeNativeFieldContainerRender.java
 *
 * Created on 14 de septiembre de 2005, 11:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeFieldContainerRender extends TypeNativeCapableRender
{
    
    /**
     * Creates a new instance of TypeNativeFieldContainerRender
     */
    public TypeNativeFieldContainerRender(TypeNativeFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
}
