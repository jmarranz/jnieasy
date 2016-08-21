/*
 * AttachCopyLifecycleEvent.java
 *
 * Created on 22 de septiembre de 2005, 18:21
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

import com.innowhere.jnieasy.core.mem.NativeAddress;

/**
 * This is the event class used in attach life cycle event notifications.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#attach(Object,NativeAddress,long)
 */
public class AttachLifecycleEvent extends InstanceLifecycleEvent
{
    private NativeAddress addr;
    private long offset;
    
    /**
     * Creates a new event object with the specified source, parent address and offset.
     * 
     * @param source the instance that triggered the event.
     * @param addr the parent address to attach.
     * @param offset the relative address.
     */
    public AttachLifecycleEvent(Object source, NativeAddress addr, long offset)
    {
        super(source,ATTACH);
        
        this.addr = addr;
        this.offset = offset;
    }
    
    /**
     * Returns the address base to attach.
     *
     * @return the address object. 
     */     
    public NativeAddress getAddress()
    {
        return addr;
    }    
    
    /**
     * Returns the relative address offset.
     *
     * @return the relative offset. 
     */
    public long getOffset()
    {
        return offset;
    }
}
