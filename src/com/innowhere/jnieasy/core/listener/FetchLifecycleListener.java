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
 * Instances of user defined native classes implementing this interface
 * are notified when fetching from native memory.
 *
 * @author Jose M. Arranz Santamaria
 */
public interface FetchLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called after the instance is fetched.
     *
     * @param event the fetch event.
     * @see FetchCallback#jnieasyPostFetch(int)
     */     
    public void postFetch(FetchLifecycleEvent event);  
}
