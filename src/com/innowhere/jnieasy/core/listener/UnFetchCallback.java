/*
 * UnFetchListener.java
 *
 * Created on 22 de septiembre de 2005, 13:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * Instances of user defined native classes implementing this interface
 * are notified when "unfetched" to native memory.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#unFetch(Object,int)
 */
public interface UnFetchCallback
{
    /**
     * Called before the instance is "unfetched".
     * <p>
     * This method is not enhanced, native fields can be accessed
     * without native memory access.
     * <p>
     * It is useful to prepare native fields before set to native memory.
     *
     * @param mode the "unfetch" mode used.
     */      
    public void jnieasyPreUnFetch(int mode);  
}
