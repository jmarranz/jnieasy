/*
 * JavaClassAsNativeFieldContainerImpl.java
 *
 * Created on 14 de septiembre de 2005, 11:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeFieldContainerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeFieldContainerImpl extends JavaClassAsNativeCapableImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeFieldContainerImpl
     */
    public JavaClassAsNativeFieldContainerImpl(ClassTypeNativeFieldContainerImpl classType)
    {
        super(classType);
    }
    
}
