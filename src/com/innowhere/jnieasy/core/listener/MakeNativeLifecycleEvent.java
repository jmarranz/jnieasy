/*
 * MakeNativeLifecycleEvent.java
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
 * This is the event class used in make native life cycle event notifications.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object)
 * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object,NativeAddress,long)
 */
public class MakeNativeLifecycleEvent extends InstanceLifecycleEvent
{
    private NativeAddress addr;
    private long offset = -1;
    private boolean attaching;
    
    /**
     * Creates a new event object with the specified source, parent address and offset.
     * 
     * @param source the instance that triggered the event.
     * @param addr the parent address to attach.
     * @param offset the relative address.
     */    
    public MakeNativeLifecycleEvent(Object source,NativeAddress addr, long offset)
    {
        super(source,MAKE_NATIVE);
        
        this.addr = addr;
        this.offset = offset;
        this.attaching = true;
    }
    
    /**
     * Creates a new event object with the specified source.
     * 
     * @param source the instance that triggered the event.
     */        
    public MakeNativeLifecycleEvent(Object source)
    {
        super(source,MAKE_NATIVE);
        
        this.attaching = false;
    }    
    
    /**
     * Returns true if is being native attaching to an address.
     * <p>
     * {@link #getAddress()} and {@link #getOffset()} offers the 
     * addressing info. 
     *
     * @return true if attaching else false. 
     */
    public boolean isAttaching()
    {
        return attaching;
    }
    
    /**
     * Returns the address base if is being native attaching to an address.
     * <p>
     * If is not attaching returns null.
     *
     * @return the address object. 
     */    
    public NativeAddress getAddress()
    {
        return addr;
    }    
    
    /**
     * Returns the relative address offset if is being native attaching to an address.
     * <p>
     * If is not attaching returns -1 (not a valid value).
     *
     * @return the relative offset. 
     */     
    public long getOffset()
    {
        return offset;
    }
}
