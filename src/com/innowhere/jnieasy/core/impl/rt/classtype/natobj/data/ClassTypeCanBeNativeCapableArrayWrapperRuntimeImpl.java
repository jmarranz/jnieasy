/*
 * ClassTypeCanBeNativeCapableArrayWrapperRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 19:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCanBeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeCanBeNativeCapableArrayWrapperRuntimeImpl extends ClassTypeNativeObjectArrayWrapperRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeCanBeNativeCapableArrayWrapperRuntimeImpl
     */
    public ClassTypeCanBeNativeCapableArrayWrapperRuntimeImpl(ClassTypeCanBeNativeCapableArrayWrapperImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
