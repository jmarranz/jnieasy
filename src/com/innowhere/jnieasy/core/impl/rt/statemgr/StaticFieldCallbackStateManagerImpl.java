/*
 * StaticFieldCallbackStateManagerImpl.java
 *
 * Created on 24 de septiembre de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.mem.NativeManager;

public class StaticFieldCallbackStateManagerImpl extends CallbackStateManagerImpl
{
    
    /**
     * Creates a new instance of StaticFieldCallbackStateManagerImpl 
     */
    public StaticFieldCallbackStateManagerImpl()
    {
    }
    
    public NativeStaticFieldCallback getStaticFieldCallback()
    {
        return (NativeStaticFieldCallback)value;
    }
    
    public Object onCallGeneric(Object[] args)
    {
        int opcode = ((Integer)args[0]).intValue();
        Object value = args[1];        
        return getStaticFieldCallback().onCall(opcode, value);
    }    
}
