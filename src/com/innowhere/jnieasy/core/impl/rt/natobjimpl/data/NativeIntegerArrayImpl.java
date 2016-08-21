/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeIntegerArrayImpl extends NativeNumberArrayImpl implements NativeIntegerArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected int[] value;
    
    /** Creates a new instance of PtrInteger */
    public NativeIntegerArrayImpl()
    {
    }
    
    public TypeNativeIntegerRuntimeImpl jnieasyGetTypeNativeIntegerComponent()
    {
        return (TypeNativeIntegerRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeIntegerRuntimeImpl typeDecComp = jnieasyGetTypeNativeIntegerComponent();
        typeDecComp.getFieldIntegerArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value; 
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((int[])newValue,stateMgr);
        
        TypeNativeIntegerRuntimeImpl typeDecComp = jnieasyGetTypeNativeIntegerComponent();
        typeDecComp.setFieldIntegerArray((int[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
    }

    public synchronized int getInt(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
            
        TypeNativeIntegerRuntimeImpl typeDecComp = jnieasyGetTypeNativeIntegerComponent();
        int res = typeDecComp.getFieldIntegerArray(index,this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);                
        
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setInt(int index,int newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }

        TypeNativeIntegerRuntimeImpl typeDecComp = jnieasyGetTypeNativeIntegerComponent();
        typeDecComp.setFieldIntegerArray(index,newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
   
                
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized int getInt(int index)
    {    
        return getInt(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setInt(int index,int newValue)
    {        
        setInt(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public int[] getIntArray()
    {
        return (int[])getValue();
    }
    
    public void setIntArray(int[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeIntegerArrayImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeIntegerArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (int[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((int[])array).clone(); 
    }    
    
    public synchronized int length()
    {
        return ((int[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Integer(getInt(index));
    }
    
    public void setElement(int index, Object value)
    {
        setInt(index,((Integer)value).intValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Integer(getInt(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setInt(index,((Integer)value).intValue(),unFetchMode);        
    }    
}
