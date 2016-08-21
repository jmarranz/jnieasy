/*
 * JavaClassAsNativeSeparatedFieldContainerImpl.java
 *
 * Created on 13 de octubre de 2005, 19:05
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeSeparatedFieldContainerImpl;


/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeSeparatedFieldContainerImpl extends JavaClassAsNativeMultipleFieldContainerImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeSeparatedFieldContainerImpl
     */
    public JavaClassAsNativeSeparatedFieldContainerImpl(ClassTypeNativeSeparatedFieldContainerImpl classType)
    {
        super(classType);
    }
}
