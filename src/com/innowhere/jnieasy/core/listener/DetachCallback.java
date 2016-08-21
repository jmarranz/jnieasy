/*
 * DetachListener.java
 *
 * Created on 22 de septiembre de 2005, 12:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when detached from native memory.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#detach(Object,int,boolean)
 */
public interface DetachCallback
{
    /**
     * Called before the instance is detached.
     *
     * @param freeMemMode free memory condition used.
     */    
    public void jnieasyPreDetach(int freeMemMode);
    
    /**
     * Called after the instance is detached.
     * <p>
     * This method is not modified by the enhancer.
     *
     */     
    public void jnieasyPostDetach();  
}
