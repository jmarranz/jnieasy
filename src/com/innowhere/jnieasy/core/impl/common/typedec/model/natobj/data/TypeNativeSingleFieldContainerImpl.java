/*
 * TypeNativeSingleFieldContainerImpl.java
 *
 * Created on 7 de octubre de 2005, 12:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeSingleFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeSingleFieldContainerImpl extends TypeNativeFieldContainerImpl
{
           
    /**
     * Creates a new instance of TypeNativeSingleFieldContainerImpl
     */
    public TypeNativeSingleFieldContainerImpl(ClassTypeNativeSingleFieldContainerImpl dataType)
    {
        super(dataType);
    }

}
