/*
 * ClassTypeNativeMultipleFieldContainerRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 20:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeMultipleFieldContainerRuntimeImpl extends ClassTypeNativeFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeMultipleFieldContainerRuntimeImpl
     */
    public ClassTypeNativeMultipleFieldContainerRuntimeImpl(ClassTypeNativeMultipleFieldContainerImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeNativeMultipleFieldContainerImpl getClassTypeMultipleFieldContainer()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)classType;
    }
}
