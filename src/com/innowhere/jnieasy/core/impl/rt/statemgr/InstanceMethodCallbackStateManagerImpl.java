/*
 * InstanceMethodCallbackStateManagerImpl.java
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


public class InstanceMethodCallbackStateManagerImpl extends CallbackStateManagerImpl
{
    
    /**
     * Creates a new instance of InstanceMethodCallbackStateManagerImpl
     */
    public InstanceMethodCallbackStateManagerImpl()
    {
    }
    
    public NativeInstanceMethodCallback getInstanceMethodCallback()
    {
        return (NativeInstanceMethodCallback)value;
    }
    
    public Object onCallGeneric(Object[] args)
    {
        int len = args.length;
        Object[] args2 = new Object[len - 1];
        System.arraycopy(args,1, args2, 0, len - 1);
        NativeMultipleFieldContainer obj = (NativeMultipleFieldContainer)args[0];
        return getInstanceMethodCallback().onCall(obj,args2);
    }
}
