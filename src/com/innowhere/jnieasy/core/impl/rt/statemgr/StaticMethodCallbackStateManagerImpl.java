/*
 * StaticMethodCallbackStateManagerImpl.java
 *
 * Created on 24 de septiembre de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.method.*;


public class StaticMethodCallbackStateManagerImpl extends CallbackStateManagerImpl
{
    
    /**
     * Creates a new instance of StaticMethodCallbackStateManagerImpl 
     */
    public StaticMethodCallbackStateManagerImpl()
    {
    }
    
    public NativeStaticMethodCallback getStaticCallback()
    {
        return (NativeStaticMethodCallback)value;
    }
    
    public Object onCallGeneric(Object[] args)
    {
        return getStaticCallback().onCall(args);
    }    
}
