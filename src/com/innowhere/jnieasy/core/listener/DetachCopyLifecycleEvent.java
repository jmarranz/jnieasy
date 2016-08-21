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
 * This is the event class used in detach copy life cycle event notifications.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#detachCopy(Object)
 */
public class DetachCopyLifecycleEvent extends InstanceLifecycleEvent
{
    private Object detachedCopy;
    
    /**
     * Creates a new event object with the specified source.
     * 
     * @param source the instance that triggered the event.
     */       
    public DetachCopyLifecycleEvent(Object source)
    {
        super(source,DETACH_COPY);
    }

    /**
     * Returns the detached/cloned object.
     *
     * @return the detached/cloned object.
     */    
    public Object getDetachedCopy()
    {
        return detachedCopy;
    }    
    
    /**
     * Sets the detached/cloned object.
     * <p>
     * Internal use.
     *
     * @param detachedCopy the detached/cloned object.
     */    
    public void setDetachedCopy(Object detachedCopy)
    {
        this.detachedCopy = detachedCopy;
    }
        
}
