/*
 * AttachLifecycleListener.java
 *
 * Created on 22 de septiembre de 2005, 18:25
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * This interface is implemented by listeners to be notified of attach events.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#attach(Object,NativeAddress,long)
 */
public interface AttachLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called before the instance is going to be attached.
     * <p>
     * It is called before the method 
     * {@link AttachCallback#jnieasyPreAttach(NativeAddress,long)} 
     * is invoked on the instance to be attached.
     *
     * @param event the attach event.
     */      
    public void preAttach(AttachLifecycleEvent event);
    
    /**
     * Called after the instance is attached.
     *
     * @param event the attach event.
     * @see AttachCallback#jnieasyPostAttach()
     */    
    public void postAttach(AttachLifecycleEvent event);    
}
