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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeIntegerObjectImpl extends NativeNumberObjectImpl implements NativeIntegerObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Integer value = new Integer(0);
    
    /** Creates a new instance of PtrInteger */
    public NativeIntegerObjectImpl()
    {
    }

    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeIntegerRuntimeImpl typeComp = (TypeNativeIntegerRuntimeImpl)jnieasyGetTypeNativePrimitive();
        int newValue = typeComp.getFieldInt(0,0,this.value.intValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.intValue() != newValue)
            this.value = new Integer(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Integer)newValue,stateMgr);

        TypeNativeIntegerRuntimeImpl typeComp = (TypeNativeIntegerRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldInt(0,0,((Integer)newValue).intValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Integer getInteger()
    {
        return (Integer)getValue();
    }

    public void setInteger(Integer newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeIntegerObjectImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeIntegerObjectImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Integer)newValue;            
    }    
}
