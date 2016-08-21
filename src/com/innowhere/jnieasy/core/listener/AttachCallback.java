/*
 * AttachListener.java
 *
 * Created on 22 de septiembre de 2005, 12:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

import com.innowhere.jnieasy.core.mem.NativeAddress;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when attached to native memory.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#attach(Object,NativeAddress,long)
 */
public interface AttachCallback
{
    /**
     * Called before the instance is attached.
     * <p>
     * This method is not modified by the enhancer.
     *
     * @param addr the address object parent to be attached.
     * @param offset the offset of the address to be attached.
     */
    public void jnieasyPreAttach(NativeAddress addr, long offset);
    
    /**
     * Called after the instance is attached.
     *
     */    
    public void jnieasyPostAttach();
}
