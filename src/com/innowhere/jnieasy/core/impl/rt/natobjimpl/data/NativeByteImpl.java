/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeSingleFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeByteImpl extends NativeNumberImpl implements NativeByte
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected byte value;
    
    /** Creates a new instance of PtrInteger */
    
    public NativeByteImpl()
    {
    }
    
    public TypeNativeByteRuntimeImpl jnieasyGetFieldTypeNativeByte()
    {
        return (TypeNativeByteRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }
    
    public byte jnieasyGetByteValue(NativeStateManager stateMgr)
    {
        TypeNativeByteRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeByte();
        this.value = typeDecField.getFieldByte(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);

        return this.value;
    }

    public void jnieasySetByteValue(byte newValue,NativeStateManager stateMgr)
    {
        TypeNativeByteRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeByte();
        typeDecField.setFieldByte(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Byte(jnieasyGetByteValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetByteValue(((Byte)newValue).byteValue(),stateMgr);
    }        
    
    public synchronized byte getByteValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetByteValue(stateMgr);
    }

    public synchronized void setByteValue(byte newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetByteValue(newValue,stateMgr);
    }    
    
    public synchronized byte getByteValue()
    {
        return getByteValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setByteValue(byte newValue)
    {
        setByteValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetByteValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetByteValue(this.value,stateMgr);
    }    
    
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetByteValue(((NativeByteImpl)detachedCopy).value,stateMgr);
    }       
    
    public Object jnieasyGetInternalValue()
    {
        return new Byte(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Byte)obj).byteValue();
    }
        
    public Object jnieasyNewInstance()
    {
        return new NativeByteImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeByteImpl[len];
    }     
        
}
