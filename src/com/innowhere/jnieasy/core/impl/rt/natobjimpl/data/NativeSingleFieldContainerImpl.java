/*
 * NativeSingleFieldContainerImpl.java
 *
 * Created on 7 de octubre de 2005, 12:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeSingleFieldContainerInternal;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;

/**
 *
 * @author jmarranz
 */
public abstract class NativeSingleFieldContainerImpl extends FieldContainerImpl implements NativeSingleFieldContainerInternal
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeSingleFieldContainerImpl
     */
    public NativeSingleFieldContainerImpl()
    {
    }
    
    public synchronized Object getValue()
    {
        int defaultFetch = NativeManagerImpl.getDefaultFetchMode(this);        
        return getValue(defaultFetch);       
    }
    
    public synchronized void setValue(Object obj)
    {
        int defaultUnFetch = NativeManagerImpl.getDefaultUnFetchMode(this);                
        setValue(obj,defaultUnFetch);
    }    
    
    public synchronized Object getValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return jnieasyGetInternalValue();
        
        NativeManagerImpl.checkFetchMode(fetchMode);
        return jnieasyGetValue(fetchMode,NativeManagerImpl.newFetchContextIfNeeded(fetchMode),stateMgr);       
    }            
      
    public synchronized void setValue(Object obj,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();        
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            jnieasySetInternalValue(obj);
            return;
        }
        
        NativeManagerImpl.checkUnFetchMode(unFetchMode);
        jnieasySetValue(obj, unFetchMode, NativeManagerImpl.newUnFetchContextIfNeeded(unFetchMode), null,stateMgr);
    }       
}
