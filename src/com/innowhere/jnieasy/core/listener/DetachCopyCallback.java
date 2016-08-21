/*
 * DetachCopyListener.java
 *
 * Created on 22 de septiembre de 2005, 12:40
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when creating a detached (non-native) clone.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#detachCopy(Object)
 */
public interface DetachCopyCallback
{
    /**
     * Called before creating the detached clone.
     *
     * It is useful to clear fields not cloneable.
     */        
    public void jnieasyPreDetachCopy();
    
    /**
     * Called after the detached clone was created.
     *
     * @param detachedCopy the cloned detached instance.
     */         
    public void jnieasyPostDetachCopy(Object detachedCopy);    
}
