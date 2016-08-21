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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;


public class NativeByteArrayImpl extends NativeNumberArrayImpl implements NativeByteArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected byte[] value;
    
    /** Creates a new instance of PtrByte */
    public NativeByteArrayImpl()
    {
    }

    public TypeNativeByteRuntimeImpl jnieasyGetTypeNativeByteComponent()
    {
        return (TypeNativeByteRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeByteRuntimeImpl typeDecComp = jnieasyGetTypeNativeByteComponent();
        typeDecComp.getFieldByteArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((byte[])newValue,stateMgr);
        
        TypeNativeByteRuntimeImpl typeDecComp = jnieasyGetTypeNativeByteComponent();
        typeDecComp.setFieldByteArray((byte[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
    }
    
    public synchronized byte getByte(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
            
        TypeNativeByteRuntimeImpl typeDecComp = jnieasyGetTypeNativeByteComponent();       
        byte res = typeDecComp.getFieldByteArray(index,this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setByte(int index,byte newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }

        TypeNativeByteRuntimeImpl typeDecComp = jnieasyGetTypeNativeByteComponent();
        typeDecComp.setFieldByteArray(index,newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized byte getByte(int index)
    {    
        return getByte(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setByte(int index,byte newValue)
    {        
        setByte(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public byte[] getByteArray()
    {
        return (byte[])getValue();
    }
    
    public void setByteArray(byte[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeByteArrayImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeByteArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (byte[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((byte[])array).clone(); 
    }    
    
    public synchronized int length()
    {
        return ((byte[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Byte(getByte(index));
    }
    
    public void setElement(int index, Object value)
    {
        setByte(index,((Byte)value).byteValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Byte(getByte(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setByte(index,((Byte)value).byteValue(),unFetchMode);        
    }    
}
