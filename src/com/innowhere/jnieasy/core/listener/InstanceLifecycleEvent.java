/*
 * InstanceLifecycleEvent.java
 *
 * Created on 22 de septiembre de 2005, 16:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

import java.util.EventObject;

/**
 * This is the event class used in life cycle event notifications.
 *
 * @author Jose M. Arranz Santamaria
  */
public class InstanceLifecycleEvent extends EventObject
{
    /**
     * Constant used to indicate an attach event.
     * 
     * @see AttachLifecycleEvent
     */
    public static final int ATTACH = 1;  
    
    /**
     * Constant used to indicate an attach copy event.
     * 
     * @see AttachCopyLifecycleEvent
     */    
    public static final int ATTACH_COPY = 2;
    
    /**
     * Constant used to indicate a detach event.
     * 
     * @see DetachLifecycleEvent
     */    
    public static final int DETACH = 3;
    
    /**
     * Constant used to indicate a detach copy event.
     * 
     * @see DetachCopyLifecycleEvent
     */    
    public static final int DETACH_COPY = 4;
    
    /**
     * Constant used to indicate a fetch event.
     * 
     * @see FetchLifecycleEvent
     */    
    public static final int FETCH = 5;
        
    /**
     * Constant used to indicate a make native event.
     * 
     * @see MakeNativeLifecycleEvent
     */     
    public static final int MAKE_NATIVE = 6;  
    
    /**
     * Constant used to indicate a "unfetch" event.
     * 
     * @see UnFetchLifecycleEvent
     */     
    public static final int UNFETCH = 7;    
    
    private int type;
    
    /**
     * Creates a new event object with the specified source and type.
     * 
     * @param source the instance that triggered the event.
     * @param type the event type.
     */
    public InstanceLifecycleEvent(Object source, int type)
    {
        super(source);
        
        this.type = type;
    }

    /**
     * Returns the event type that triggered this event.
     *
     * @return the event type.
     */
    public int getEventType()    
    {
        return type;
    }

}
