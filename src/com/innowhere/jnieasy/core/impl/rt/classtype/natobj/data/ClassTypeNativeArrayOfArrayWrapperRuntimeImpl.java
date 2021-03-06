/*
 * ClassTypeNativeArrayOfArrayWrapperRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 19:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeArrayOfArrayWrapperRuntimeImpl extends ClassTypeCanBeNativeCapableArrayWrapperRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayWrapperRuntimeImpl
     */
    public ClassTypeNativeArrayOfArrayWrapperRuntimeImpl(ClassTypeNativeArrayOfArrayWrapperImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
