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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeDoubleObjectImpl extends NativeNumberObjectImpl implements NativeDoubleObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Double value = new Double(0);
    
    /** Creates a new instance of PtrDouble */
    public NativeDoubleObjectImpl()
    {
    }

    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeDoubleRuntimeImpl typeComp = (TypeNativeDoubleRuntimeImpl)jnieasyGetTypeNativePrimitive();
        double newValue = typeComp.getFieldDouble(0,0,this.value.doubleValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.doubleValue() != newValue)
            this.value = new Double(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Double)newValue,stateMgr);

        TypeNativeDoubleRuntimeImpl typeComp = (TypeNativeDoubleRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldDouble(0,0,((Double)newValue).doubleValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }

    public Double getDouble()
    {
        return (Double)getValue();
    }

    public void setDouble(Double newValue)
    {
        setValue(newValue);
    }    
   
    public Object jnieasyNewInstance()
    {
        return new NativeDoubleObjectImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeDoubleObjectImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Double)newValue;            
    }     
}
