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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeDoubleArrayImpl extends NativeNumberArrayImpl implements NativeDoubleArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected double[] value;
    
    /** Creates a new instance of PtrDouble */
    public NativeDoubleArrayImpl()
    {
    }
    
    public TypeNativeDoubleRuntimeImpl jnieasyGetTypeNativeDoubleComponent()
    {
        return (TypeNativeDoubleRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeDoubleRuntimeImpl typeDecComp = jnieasyGetTypeNativeDoubleComponent();
        typeDecComp.getFieldDoubleArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value; 
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((double[])newValue,stateMgr);
        
        TypeNativeDoubleRuntimeImpl typeDecComp = jnieasyGetTypeNativeDoubleComponent();
        typeDecComp.setFieldDoubleArray((double[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
    }
    
    public synchronized double getDouble(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
            
        TypeNativeDoubleRuntimeImpl typeDecComp = jnieasyGetTypeNativeDoubleComponent();
        //long size = typeDecComp.size();        
        double res = typeDecComp.getFieldDoubleArray(index,this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setDouble(int index,double newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }

        TypeNativeDoubleRuntimeImpl typeDecComp = jnieasyGetTypeNativeDoubleComponent();
        typeDecComp.setFieldDoubleArray(index,newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized double getDouble(int index)
    {    
        return getDouble(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setDouble(int index,double newValue)
    {        
        setDouble(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }

    public double[] getDoubleArray()
    {
        return (double[])getValue();
    }
    
    public void setDoubleArray(double[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeDoubleArrayImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeDoubleArrayImpl[len];
    }     
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (double[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((double[])array).clone(); 
    }    
    
    public synchronized int length()
    {
        return ((double[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Double(getDouble(index));
    }
    
    public void setElement(int index, Object value)
    {
        setDouble(index,((Double)value).doubleValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Double(getDouble(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setDouble(index,((Double)value).doubleValue(),unFetchMode);        
    }    
}
