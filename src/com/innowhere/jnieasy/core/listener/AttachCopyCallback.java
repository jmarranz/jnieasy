/*
 * AttachCopyListener.java
 *
 * Created on 22 de septiembre de 2005, 12:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when attaching a non-native (detached) copy.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#attachCopy(Object,Object)
 */
public interface AttachCopyCallback
{
    /**
     * Called before the instance is going to receive a non-native copy.
     */    
    public void jnieasyPreAttachCopy();
    
    /**
     * Called after the copy instance was set.
     * <p>
     * It is useful to copy non-native fields of the non-native instance.
     *
     * @param detachedCopy the non-native instance to copy.
     */     
    public void jnieasyPostAttachCopy(Object detachedCopy);    
}
