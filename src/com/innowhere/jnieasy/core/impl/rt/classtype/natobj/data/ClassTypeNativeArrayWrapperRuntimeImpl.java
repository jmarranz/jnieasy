/*
 * ClassTypeNativeArrayWrapperRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 19:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeSingleFieldContainerInternal;




/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeArrayWrapperRuntimeImpl extends ClassTypeCanBeNativeCapableWrapperRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeArrayWrapperRuntimeImpl
     */
    public ClassTypeNativeArrayWrapperRuntimeImpl(ClassTypeNativeArrayWrapperImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public int getLength(Object arrayValue)
    {
        ClassTypeNativeArrayRuntimeImpl classType = (ClassTypeNativeArrayRuntimeImpl)getClassTypeCanBeNativeCapableRuntime();
        Object internalArrayValue = ((NativeSingleFieldContainerInternal)arrayValue).jnieasyGetInternalValue();
        return classType.getLength(internalArrayValue);
    }    
}
