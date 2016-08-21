/*
 * ClassTypeNativeSeparatedFieldContainerRuntimeImpl.java
 *
 * Created on 13 de octubre de 2005, 19:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeSeparatedFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeSeparatedFieldContainerRuntimeImpl extends ClassTypeNativeMultipleFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeSeparatedFieldContainerRuntimeImpl
     */
    public ClassTypeNativeSeparatedFieldContainerRuntimeImpl(ClassTypeNativeSeparatedFieldContainerImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
