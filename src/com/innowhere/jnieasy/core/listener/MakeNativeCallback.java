/*
 * MakeNativeListener.java
 *
 * Created on 22 de septiembre de 2005, 12:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

import com.innowhere.jnieasy.core.mem.NativeAddress;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when made native "unfetching" to native memory.
 *
 * @author Jose M. Arranz Santamaria
 */
public interface MakeNativeCallback
{
    /**
     * Called before the instance is made native with its own address.
     * <p>
     * Native declared fields that might have been affected by  
     * non-native fields should be updated in this method before being copied
     * to native memory.
     * <p>
     * This method is not modified by the enhancer.
     *
     * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object)
     */    
    public void jnieasyPreMakeNative();
    
    /**
     * Called before the instance is made native attaching to the 
     * specified address+offset.
     * <p>
     * Native declared fields that might have been affected by  
     * non-native fields should be updated in this method before being copied
     * to native memory.
     * <p>
     * This method is not modified by the enhancer.
     * 
     * 
     * @param addr the address object parent to be attached.
     * @param offset the offset of the address to be attached.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object,NativeAddress,long)
     */
    public void jnieasyPreMakeNative(NativeAddress addr, long offset);  
    
    /**
     * Called after the instance is made native.
     *
     */    
    public void jnieasyPostMakeNative();        
}
