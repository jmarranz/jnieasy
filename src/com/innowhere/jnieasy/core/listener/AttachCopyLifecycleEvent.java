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
 * This is the event class used in attach copy life cycle event notifications.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#attachCopy(Object,Object)
 */
public class AttachCopyLifecycleEvent extends InstanceLifecycleEvent
{
    private Object detachedCopy;
    
    /**
     * Creates a new event object with the specified source and detached copy.
     * 
     * @param source the instance that triggered the event.
     * @param detachedCopy the detached object being copied.
     */    
    public AttachCopyLifecycleEvent(Object source, Object detachedCopy)
    {
        super(source,ATTACH_COPY);

        this.detachedCopy = detachedCopy;
    }
    
    /**
     * Returns the detached object being copied.
     *
     * @return the detached object.
     */
    public Object getDetachedCopy()
    {
        return detachedCopy;
    }    
}
