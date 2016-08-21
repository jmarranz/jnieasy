/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeSingleFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeLongObjectImpl extends NativeNumberObjectImpl implements NativeLongObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Long value = new Long(0);
    
    /** Creates a new instance of PtrLong */
    public NativeLongObjectImpl()
    {
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeLongRuntimeImpl typeComp = (TypeNativeLongRuntimeImpl)jnieasyGetTypeNativePrimitive();
        long newValue = typeComp.getFieldLong(0,0,this.value.longValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.longValue() != newValue)
            this.value = new Long(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Long)newValue,stateMgr);

        TypeNativeLongRuntimeImpl typeComp = (TypeNativeLongRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldLong(0,0,((Long)newValue).longValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Long getLong()
    {
        return (Long)getValue();
    }

    public void setLong(Long newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeLongObjectImpl();
    }   
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeLongObjectImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Long)newValue;            
    }     
}
