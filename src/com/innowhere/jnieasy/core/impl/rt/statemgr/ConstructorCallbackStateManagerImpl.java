/*
 * ConstructorCallbackStateManagerImpl.java
 *
 * Created on 24 de septiembre de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.method.*;

/**
 *
 * @author  jmarranz
 */

public class ConstructorCallbackStateManagerImpl extends CallbackStateManagerImpl
{
    
    /**
     * Creates a new instance of ConstructorCallbackStateManagerImpl 
     */
    public ConstructorCallbackStateManagerImpl()
    {
    }
    
    public NativeConstructorCallback getConstructorCallback()
    {
        return (NativeConstructorCallback)value;
    }
    
    public Object onCallGeneric(Object[] args)
    {
        return (NativeMultipleFieldContainer)getConstructorCallback().onCall(args);
    }
}
