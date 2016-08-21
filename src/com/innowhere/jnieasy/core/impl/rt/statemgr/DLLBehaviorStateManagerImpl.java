/*
 * DLLBehaviorStateManagerImpl.java
 *
 * Created on 10 de octubre de 2005, 18:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;

/**
 *
 * @author jmarranz
 */
public class DLLBehaviorStateManagerImpl extends NativeStateManagerImpl
{
    
    /**
     * Creates a new instance of DLLBehaviorStateManagerImpl
     */
    public DLLBehaviorStateManagerImpl()
    {
    }

    public void allocateBuffer(NativeManagerImpl memMgr,NativeCapableInternal value)
    {
        // Es siempre "attached"
        throw new JNIEasyException("INTERNAL ERROR");
    }
    
    public boolean isMemoryExecutable()
    {
        return false;
    }
    
}
