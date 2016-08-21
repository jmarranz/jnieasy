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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeFloatArrayImpl extends NativeNumberArrayImpl implements NativeFloatArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected float[] value;
    
    /** Creates a new instance of PtrBoolean */
    public NativeFloatArrayImpl()
    {
    }

    public TypeNativeFloatRuntimeImpl jnieasyGetTypeNativeFloatComponent()
    {
        return (TypeNativeFloatRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeFloatRuntimeImpl typeDecComp = jnieasyGetTypeNativeFloatComponent();
        typeDecComp.getFieldFloatArray(value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value;        
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((float[])newValue,stateMgr);        
        
        TypeNativeFloatRuntimeImpl typeDecComp = jnieasyGetTypeNativeFloatComponent();
        typeDecComp.setFieldFloatArray((float[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);      
    }
    
    public synchronized float getFloat(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
        
        TypeNativeFloatRuntimeImpl typeDecComp = jnieasyGetTypeNativeFloatComponent();
        float res = typeDecComp.getFieldFloatArray(index,this.value,stateMgr);
        
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setFloat(int index,float newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }

        TypeNativeFloatRuntimeImpl typeDecComp = jnieasyGetTypeNativeFloatComponent();
        typeDecComp.setFieldFloatArray(index,newValue,stateMgr);
        
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized float getFloat(int index)
    {    
        return getFloat(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setFloat(int index,float newValue)
    {        
        setFloat(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public float[] getFloatArray()
    {
        return (float[])getValue();
    }
    
    public void setFloatArray(float[] newValue)
    {
        setValue(newValue);
    }
       
    public Object jnieasyNewInstance()
    {
        return new NativeFloatArrayImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeFloatArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (float[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((float[])array).clone(); 
    }    
    
    public synchronized int length()
    {
        return ((float[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Float(getFloat(index));
    }
    
    public void setElement(int index, Object value)
    {
        setFloat(index,((Float)value).floatValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Float(getFloat(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setFloat(index,((Float)value).floatValue(),unFetchMode);        
    }
   
}
