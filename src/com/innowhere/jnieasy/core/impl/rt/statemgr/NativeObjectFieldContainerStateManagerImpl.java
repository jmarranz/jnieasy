/*
 * NativeObjectFieldContainerStateManagerImpl.java
 *
 * Created on 29 de septiembre de 2005, 17:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeObjectFieldContainerInternal;



/**
 *
 * @author jmarranz
 */
public abstract class NativeObjectFieldContainerStateManagerImpl extends NativeSingleFieldContainerStateManagerImpl
{
    
    /**
     * Creates a new instance of NativeObjectFieldContainerStateManagerImpl
     */
    public NativeObjectFieldContainerStateManagerImpl()
    {
    }    

    public NativeObjectFieldContainerInternal getObjectFieldContainerInternal()
    {
        return (NativeObjectFieldContainerInternal)value;
    }    
    
    public boolean needAuxObjects()
    {
        NativeObjectFieldContainerInternal  nativeObj = getObjectFieldContainerInternal();
        return nativeObj.jnieasyNeedAuxObjects();
    }
}
