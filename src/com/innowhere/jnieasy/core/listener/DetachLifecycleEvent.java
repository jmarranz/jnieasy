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

/**
 * This is the event class used in detach life cycle event notifications.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#detach(Object,int,boolean) 
 */
public class DetachLifecycleEvent extends InstanceLifecycleEvent
{
    private int freeMemMode;
    
    /**
     * Creates a new event object with the specified source, and free memory mode.
     * 
     * @param source the instance that triggered the event.
     * @param freeMemMode the free memory mode used to detach.
     */
    public DetachLifecycleEvent(Object source, int freeMemMode)
    {
        super(source,DETACH);

        this.freeMemMode = freeMemMode;
    }

    /**
     * Returns the free memory mode used to detach.
     *
     * @return the free memory mode.
     */
    public int getFreeMemoryMode()
    {
        return freeMemMode;
    }
}
