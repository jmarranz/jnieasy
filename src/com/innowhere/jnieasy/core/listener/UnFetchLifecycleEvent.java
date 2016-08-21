/*
 * UnFetchLifecycleEvent.java
 *
 * Created on 22 de septiembre de 2005, 18:21
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * This is the event class used in "unfetch" life cycle event notifications.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#unFetch(Object,int)
 */
public class UnFetchLifecycleEvent extends InstanceLifecycleEvent
{
    private int mode;
    
    /**
     * Creates a new event object with the specified source and "unfetch" mode.
     * 
     * @param source the instance that triggered the event.
     * @param mode the mode being used to "unfetch" the source object.
     */    
    public UnFetchLifecycleEvent(Object source,int mode)
    {
        super(source,UNFETCH);

        this.mode = mode;
    }
    
    /**
     * Returns the mode being used to "unfetch" the source object.
     *
     * @return the "unfetch" mode. 
     */    
    public int getMode()
    {
        return mode;
    }    
}
