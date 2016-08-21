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
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeBooleanArrayImpl extends NativePrimitiveArrayImpl implements NativeBooleanArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected boolean[] value;
            
    /** Creates a new instance of PtrBoolean */
    public NativeBooleanArrayImpl()
    {
    }

    public TypeNativeBooleanRuntimeImpl jnieasyGetTypeNativeBooleanComponent()
    {
        return (TypeNativeBooleanRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeBooleanRuntimeImpl typeDecComp = jnieasyGetTypeNativeBooleanComponent();
        typeDecComp.getFieldBooleanArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((boolean[])newValue,stateMgr);
           
        TypeNativeBooleanRuntimeImpl typeDecComp = jnieasyGetTypeNativeBooleanComponent();        
        typeDecComp.setFieldBooleanArray((boolean[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
    }
        
    public synchronized boolean getBoolean(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
            
        TypeNativeBooleanRuntimeImpl typeDecComp = jnieasyGetTypeNativeBooleanComponent();        
        boolean res = typeDecComp.getFieldBooleanArray(index,this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setBoolean(int index,boolean newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }       
        
        TypeNativeBooleanRuntimeImpl typeDecComp = jnieasyGetTypeNativeBooleanComponent();
        typeDecComp.setFieldBooleanArray(index,newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);        
                
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized boolean getBoolean(int index)
    {    
        return getBoolean(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setBoolean(int index,boolean newValue)
    {        
        setBoolean(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public boolean[] getBooleanArray()
    {
        return (boolean[])getValue();
    }
    
    public void setBooleanArray(boolean[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeBooleanArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeBooleanArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (boolean[])newValue;            
    }           

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((boolean[])array).clone(); 
    }
    
    public synchronized int length()
    {
        return ((boolean[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return Boolean.valueOf(getBoolean(index));
    }
    
    public void setElement(int index, Object value)
    {
        setBoolean(index,((Boolean)value).booleanValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return Boolean.valueOf(getBoolean(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setBoolean(index,((Boolean)value).booleanValue(),unFetchMode);        
    }    
}
