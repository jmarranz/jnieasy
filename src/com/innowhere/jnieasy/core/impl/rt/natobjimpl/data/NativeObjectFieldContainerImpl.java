/*
 * NativeObjectFieldContainerImpl.java
 *
 * Created on 29 de septiembre de 2005, 13:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeObjectFieldContainerInternal;
import com.innowhere.jnieasy.core.mem.NativeStateManager;

/**
 *
 * @author jmarranz
 */
public abstract class NativeObjectFieldContainerImpl extends NativeSingleFieldContainerImpl implements NativeObjectFieldContainerInternal
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeObjectFieldContainerImpl
     */
    public NativeObjectFieldContainerImpl()
    {
    }
    
       
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetValue(mode,fetchCtx,stateMgr);
    }    
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetValue(jnieasyGetInternalValue(),mode,unfetchCtx,attachCopyCtx,stateMgr);
    }    
        
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetValue(((NativeObjectFieldContainerInternal)detachedCopy).jnieasyGetInternalValue(),NativeManagerImpl.getDefaultUnFetchMode(this),null,attachCopyCtx,stateMgr);
    }    
}
