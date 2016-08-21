/*
 * FetchListener.java
 *
 * Created on 22 de septiembre de 2005, 12:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when fetched from native memory.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#fetch(Object,int)
 */
public interface FetchCallback
{
    /**
     * Called after the instance is fetched.
     * <p>
     * This method is not enhanced, native fields can be accessed
     * without native memory access.
     * <p>
     * It is useful to synchronize non-native fields with native.
     *
     * @param mode the fetch mode used.
     */      
    public void jnieasyPostFetch(int mode); 
}
