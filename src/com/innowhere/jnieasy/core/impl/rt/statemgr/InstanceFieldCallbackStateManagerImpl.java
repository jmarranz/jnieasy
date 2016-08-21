/*
 * InstanceFieldCallbackStateManagerImpl.java
 *
 * Created on 24 de septiembre de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.data.*;


public class InstanceFieldCallbackStateManagerImpl extends CallbackStateManagerImpl
{
    
    /**
     * Creates a new instance of InstanceFieldCallbackStateManagerImpl
     */
    public InstanceFieldCallbackStateManagerImpl()
    {
    }
    
    public NativeInstanceFieldCallback getInstanceFieldCallback()
    {
        return (NativeInstanceFieldCallback)value;
    }
    
    public Object onCallGeneric(Object[] args)
    {
        NativeMultipleFieldContainer obj = (NativeMultipleFieldContainer)args[0];
        int opcode = ((Integer)args[1]).intValue();
        Object value = args[2];
        return getInstanceFieldCallback().onCall(obj,opcode,value);
    }
}
