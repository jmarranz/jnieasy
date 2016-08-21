/*
 * TypeNativeFieldContainerImpl.java
 *
 * Created on 14 de septiembre de 2005, 11:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeFieldContainerImpl extends TypeNativeCapableImpl
{
    
    /**
     * Creates a new instance of TypeNativeFieldContainerImpl
     */
    public TypeNativeFieldContainerImpl(ClassTypeNativeFieldContainerImpl dataType)
    {
        super(dataType);
    }
    
}
