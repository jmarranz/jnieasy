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
 * are notified when "unfetching" to native memory.
 *
 * @author Jose M. Arranz Santamaria
 */
public interface UnFetchLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called before the instance is fetched.
     * <p>
     * It is called before the method {@link UnFetchCallback#jnieasyPreUnFetch(int)} 
     * is invoked on the native instance.
     *
     * @param event the "unfetch" event.
     */
    public void preUnFetch(UnFetchLifecycleEvent event);    
}
