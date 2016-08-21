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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeBooleanObjectImpl extends NativePrimitiveObjectImpl implements NativeBooleanObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Boolean value = Boolean.valueOf(false);
    
    /** Creates a new instance of PtrBoolean */
    public NativeBooleanObjectImpl()
    {
    }

    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeBooleanRuntimeImpl typeComp = (TypeNativeBooleanRuntimeImpl)jnieasyGetTypeNativePrimitive();
        boolean newValue = typeComp.getFieldBoolean(0,0,this.value.booleanValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.booleanValue() != newValue)
            this.value = Boolean.valueOf(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Boolean)newValue,stateMgr);

        TypeNativeBooleanRuntimeImpl typeComp = (TypeNativeBooleanRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldBoolean(0,0,((Boolean)newValue).booleanValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Boolean getBoolean()
    {
        return (Boolean)getValue();
    }

    public void setBoolean(Boolean newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeBooleanObjectImpl();
    } 
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeBooleanObjectImpl[len];
    }     
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Boolean)newValue;            
    }     
}
