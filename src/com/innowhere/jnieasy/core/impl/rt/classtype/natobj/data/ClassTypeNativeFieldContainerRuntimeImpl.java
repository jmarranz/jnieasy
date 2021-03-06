/*
 * ClassTypeNativeFieldContainerRuntimeImpl.java
 *
 * Created on 14 de septiembre de 2005, 12:17
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeFieldContainerRuntimeImpl extends ClassTypeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeFieldContainerRuntimeImpl
     */
    public ClassTypeNativeFieldContainerRuntimeImpl(ClassTypeNativeFieldContainerImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
