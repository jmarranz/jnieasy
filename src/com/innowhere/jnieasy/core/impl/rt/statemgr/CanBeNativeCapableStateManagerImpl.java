/*
 * CanBeNativeCapableStateManagerImpl.java
 *
 * Created on 10 de octubre de 2005, 9:10
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.mem.NativeAddress;

/**
 *
 * @author jmarranz
 */
public abstract class CanBeNativeCapableStateManagerImpl extends NativeObjectFieldContainerStateManagerImpl
{
    
    /**
     * Creates a new instance of CanBeNativeCapableStateManagerImpl
     */
    public CanBeNativeCapableStateManagerImpl()
    {
    }    

    public CanBeNativeCapableInternal getCanBeNativeCapableInternal()
    {
        return (CanBeNativeCapableInternal)value;
    }
    
    public void attachBuffer(NativeAddress address, long offset,NativeManagerImpl nativeMgr,NativeCapableInternal value,boolean isAuxiliar)
    {
        CanBeNativeCapableInternal cbnValue = (CanBeNativeCapableInternal)value;
        if (cbnValue.jnieasyGetInternalValue() == null)
            cbnValue.jnieasySetInternalValue(cbnValue.jnieasyNewWrappedValue());  // puede devolver null

        super.attachBuffer(address, offset,nativeMgr, value,isAuxiliar);
    }
    
}
