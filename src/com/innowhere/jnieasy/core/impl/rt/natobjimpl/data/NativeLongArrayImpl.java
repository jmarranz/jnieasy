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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeLongArrayImpl extends NativeNumberArrayImpl implements NativeLongArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected long[] value;
    
    /** Creates a new instance of PtrLong */
    public NativeLongArrayImpl()
    {
    }

    public TypeNativeLongRuntimeImpl jnieasyGetTypeNativeLongComponent()
    {
        return (TypeNativeLongRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeLongRuntimeImpl typeDecComp = jnieasyGetTypeNativeLongComponent();
        typeDecComp.getFieldLongArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((long[])newValue,stateMgr);       

        TypeNativeLongRuntimeImpl typeDecComp = jnieasyGetTypeNativeLongComponent();        
        typeDecComp.setFieldLongArray((long[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
    }
   
    public synchronized long getLong(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];

        TypeNativeLongRuntimeImpl typeDecComp = jnieasyGetTypeNativeLongComponent();        
        long res = typeDecComp.getFieldLongArray(index,this.value,stateMgr);
        
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setLong(int index,long newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }
        
        TypeNativeLongRuntimeImpl typeDecComp = jnieasyGetTypeNativeLongComponent();
        typeDecComp.setFieldLongArray(index,newValue,stateMgr);
            
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized long getLong(int index)
    {    
        return getLong(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setLong(int index,long newValue)
    {        
        setLong(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public long[] getLongArray()
    {
        return (long[])getValue();
    }
    
    public void setLongArray(long[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeLongArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeLongArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (long[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((long[])array).clone(); 
    }    

    public synchronized int length()
    {
        return ((long[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Long(getLong(index));
    }
    
    public void setElement(int index, Object value)
    {
        setLong(index,((Long)value).longValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Long(getLong(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setLong(index,((Long)value).longValue(),unFetchMode);        
    }    

}
