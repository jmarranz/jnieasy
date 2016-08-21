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
 * This interface is implemented by listeners to be notified of detach events.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#detach(Object,int,boolean)
 */
public interface DetachLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called before the instance is going to be detached.
     * <p>
     * It is called before the method 
     * {@link DetachCallback#jnieasyPreDetach(int)} 
     * is invoked on the instance to be detached.
     *
     * @param event detach event.
     */    
    public void preDetach(DetachLifecycleEvent event);
    
    /**
     * Called after the instance is detached.
     *
     * @param event detach event.
     * @see DetachCallback#jnieasyPostDetach()
     */     
    public void postDetach(DetachLifecycleEvent event);    
}
