/*
 * ClassTypeCanBeNativeCapableWrapperRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 19:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeCanBeNativeCapableRuntimeImpl;


/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeCanBeNativeCapableWrapperRuntimeImpl extends ClassTypeNativeFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeCanBeNativeCapableWrapperRuntimeImpl
     */
    public ClassTypeCanBeNativeCapableWrapperRuntimeImpl(ClassTypeCanBeNativeCapableWrapperImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeCanBeNativeCapableWrapperImpl getClassTypeCanBeNativeCapableWrapper()
    {
        return (ClassTypeCanBeNativeCapableWrapperImpl)classType;
    }
    
    public ClassTypeCanBeNativeCapableRuntimeImpl getClassTypeCanBeNativeCapableRuntime()
    {
        ClassTypeCanBeNativeCapableWrapperImpl classType = getClassTypeCanBeNativeCapableWrapper();
        return (ClassTypeCanBeNativeCapableRuntimeImpl)classType.getClassTypeRuntime();
    }
    
}
