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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeFloatObjectImpl extends NativeNumberObjectImpl implements NativeFloatObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Float value = new Float(0);
    
    /** Creates a new instance of PtrFloat */
    public NativeFloatObjectImpl()
    {
    }
        
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeFloatRuntimeImpl typeComp = (TypeNativeFloatRuntimeImpl)jnieasyGetTypeNativePrimitive();
        float newValue = typeComp.getFieldFloat(0,0,this.value.floatValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.floatValue() != newValue)
            this.value = new Float(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Float)newValue,stateMgr);

        TypeNativeFloatRuntimeImpl typeComp = (TypeNativeFloatRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldFloat(0,0,((Float)newValue).floatValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Float getFloat()
    {
        return (Float)getValue();
    }

    public void setFloat(Float newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeFloatObjectImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeFloatObjectImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Float)newValue;            
    }    
}
