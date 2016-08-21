/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.data.NativeShortArray;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeShortRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;


/**
 *
 * @author  jmarranz
 */


public class NativeShortArrayImpl extends NativeNumberArrayImpl implements NativeShortArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected short[] value;
    
    /** Creates a new instance of PtrShort */
    public NativeShortArrayImpl()
    {
    }
    
    public TypeNativeShortRuntimeImpl jnieasyGetTypeNativeShortComponent()
    {
        return (TypeNativeShortRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeShortRuntimeImpl typeDecComp = jnieasyGetTypeNativeShortComponent();
        typeDecComp.getFieldShortArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value;        
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((short[])newValue,stateMgr);
        
        TypeNativeShortRuntimeImpl typeDecComp = jnieasyGetTypeNativeShortComponent();
        typeDecComp.setFieldShortArray((short[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);       
    }
    
    public synchronized short getShort(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
            
        TypeNativeShortRuntimeImpl typeDecComp = jnieasyGetTypeNativeShortComponent();
        short res = typeDecComp.getFieldShortArray(index,this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);  

        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setShort(int index,short newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }

        TypeNativeShortRuntimeImpl typeDecComp = jnieasyGetTypeNativeShortComponent();
        typeDecComp.setFieldShortArray(index,newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);         
        
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized short getShort(int index)
    {    
        return getShort(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setShort(int index,short newValue)
    {        
        setShort(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public short[] getShortArray()
    {
        return (short[])getValue();
    }
    
    public void setShortArray(short[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeShortArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeShortArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (short[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((short[])array).clone(); 
    }    
    
    public synchronized int length()
    {
        return ((short[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Short(getShort(index));
    }
    
    public void setElement(int index, Object value)
    {
        setShort(index,((Short)value).shortValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Short(getShort(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setShort(index,((Short)value).shortValue(),unFetchMode);        
    }    
}
