/*
 * AttachLifecycleListener.java
 *
 * Created on 22 de septiembre de 2005, 18:25
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

/**
 * This interface is implemented by listeners to be notified of make native events.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object) 
 * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object,NativeAddress,long)
 */
public interface MakeNativeLifecycleListener extends InstanceLifecycleListener
{
    /**
     * Called before the instance is going to be made native.
     * <p>
     * It is called before the method 
     * {@link MakeNativeCallback#jnieasyPreMakeNative(NativeAddress,long)} 
     * of {@link MakeNativeCallback#jnieasyPreMakeNative()} 
     * is invoked on the instance to be attached.
     *
     * @param event the make native event.
     */        
    public void preMakeNative(MakeNativeLifecycleEvent event);     
    
    /**
     * Called after the instance is made native.
     *
     * @param event the make native event.
     * @see MakeNativeCallback#jnieasyPostMakeNative()
     */     
    public void postMakeNative(MakeNativeLifecycleEvent event);    
}
