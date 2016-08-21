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
 * This interface is implemented by listeners to be notified of attach copy events.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#attachCopy(Object,Object)
 */
public interface AttachCopyLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called before the native instance is going to receive a non-native copy.
     * <p>
     * It is called before the method {@link AttachCopyCallback#jnieasyPreAttachCopy()} 
     * is invoked on the instance receiving the copy.
     *
     * @param event the attach copy event.
     */     
    public void preAttachCopy(AttachCopyLifecycleEvent event);
    
    /**
     * Called after the copy instance was set.
     *
     * @param event the attach copy event.
     * @see AttachCopyCallback#jnieasyPostAttachCopy(Object)
     */     
    public void postAttachCopy(AttachCopyLifecycleEvent event);
}
