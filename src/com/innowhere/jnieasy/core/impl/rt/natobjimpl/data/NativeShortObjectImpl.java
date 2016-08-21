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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeShortRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeShortObjectImpl extends NativeNumberObjectImpl implements NativeShortObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Short value = new Short((short)0);
    
    /** Creates a new instance of PtrShort */
    public NativeShortObjectImpl()
    {
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeShortRuntimeImpl typeComp = (TypeNativeShortRuntimeImpl)jnieasyGetTypeNativePrimitive();
        short newValue = typeComp.getFieldShort(0,0,this.value.shortValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.shortValue() != newValue)
            this.value = new Short(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Short)newValue,stateMgr);

        TypeNativeShortRuntimeImpl typeComp = (TypeNativeShortRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldShort(0,0,((Short)newValue).shortValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Short getShort()
    {
        return (Short)getValue();
    }

    public void setShort(Short newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeShortObjectImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeShortObjectImpl[len];
    }     
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Short)newValue;            
    }     
}
