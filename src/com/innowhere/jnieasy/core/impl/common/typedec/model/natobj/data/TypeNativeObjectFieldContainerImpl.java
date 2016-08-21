/*
 * TypeNativeObjectFieldContainerImpl.java
 *
 * Created on 29 de septiembre de 2005, 13:41
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeObjectFieldContainerImpl extends TypeNativeSingleFieldContainerImpl
{
    
    /**
     * Creates a new instance of TypeNativeObjectFieldContainerImpl
     */
    public TypeNativeObjectFieldContainerImpl(ClassTypeNativeObjectFieldContainerImpl dataType)
    {
        super(dataType);
    }
    
}
