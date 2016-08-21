/*
 * TypeNativeObjectFieldContainerXML.java
 *
 * Created on 29 de septiembre de 2005, 13:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeObjectFieldContainerXML extends TypeNativeSingleFieldContainerXML
{
    
    /**
     * Creates a new instance of TypeNativeObjectFieldContainerXML
     */
    public TypeNativeObjectFieldContainerXML(TypeNativeObjectFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
}
