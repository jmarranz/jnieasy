/*
 * TypeNativeObjectFieldContainerRender.java
 *
 * Created on 29 de septiembre de 2005, 13:42
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeObjectFieldContainerRender extends TypeNativeSingleFieldContainerRender
{
    
    /**
     * Creates a new instance of TypeNativeObjectFieldContainerRender
     */
    public TypeNativeObjectFieldContainerRender(TypeNativeObjectFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
}
