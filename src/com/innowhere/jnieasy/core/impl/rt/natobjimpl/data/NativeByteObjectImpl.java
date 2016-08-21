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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeByteObjectImpl extends NativeNumberObjectImpl implements NativeByteObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Byte value = new Byte((byte)0);
    
    /** Creates a new instance of PtrByte */
    public NativeByteObjectImpl()
    {
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeByteRuntimeImpl typeComp = (TypeNativeByteRuntimeImpl)jnieasyGetTypeNativePrimitive();
        byte newValue = typeComp.getFieldByte(0,0,this.value.byteValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.byteValue() != newValue)
            this.value = new Byte(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Byte)newValue,stateMgr);

        TypeNativeByteRuntimeImpl typeComp = (TypeNativeByteRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldByte(0,0,((Byte)newValue).byteValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Byte getByte()
    {
        return (Byte)getValue();
    }

    public void setByte(Byte newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeByteObjectImpl();
    } 
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeByteObjectImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Byte)newValue;            
    }     
}
