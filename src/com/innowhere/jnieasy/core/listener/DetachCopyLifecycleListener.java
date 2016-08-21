/*
 * AttachCopyLifecycleListener.java
 *
 * Created on 22 de septiembre de 2005, 16:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * This interface is implemented by listeners to be notified of detach copy events.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#detachCopy(Object)
 */
public interface DetachCopyLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called before creating the detached clone of the native instance.
     * <p>
     * It is called before the method {@link DetachCopyCallback#jnieasyPreDetachCopy()} 
     * is invoked on the native instance.
     *
     * @param event the detach copy event.
     */
    public void preDetachCopy(DetachCopyLifecycleEvent event);
    
    /**
     * Called after the detached clone was created.
     *
     * @param event detach copy event.
     * @see DetachCopyCallback#jnieasyPostDetachCopy(Object)
     */  
    public void postDetachCopy(DetachCopyLifecycleEvent event);    
}
