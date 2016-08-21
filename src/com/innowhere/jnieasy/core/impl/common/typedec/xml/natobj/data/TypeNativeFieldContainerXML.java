/*
 * TypeNativeFieldContainerXML.java
 *
 * Created on 14 de septiembre de 2005, 11:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeFieldContainerXML extends TypeNativeCapableXML
{
    
    /**
     * Creates a new instance of TypeNativeFieldContainerXML
     */
    public TypeNativeFieldContainerXML(TypeNativeFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
}
