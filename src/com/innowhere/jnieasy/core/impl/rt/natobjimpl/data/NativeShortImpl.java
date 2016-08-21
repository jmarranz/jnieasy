/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeSingleFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeShortRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeShortImpl extends NativeNumberImpl implements NativeShort
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected short value;
    
    /** Creates a new instance of PtrInteger */
    public NativeShortImpl()
    {
    }

    public TypeNativeShortRuntimeImpl jnieasyGetFieldTypeNativeShort()
    {
        return (TypeNativeShortRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }
    
    public short jnieasyGetShortValue(NativeStateManager stateMgr)
    {
        TypeNativeShortRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeShort();
        this.value = typeDecField.getFieldShort(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);

        return this.value;
    }

    public void jnieasySetShortValue(short newValue,NativeStateManager stateMgr)
    {
        TypeNativeShortRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeShort();
        typeDecField.setFieldShort(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Short(jnieasyGetShortValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetShortValue(((Short)newValue).shortValue(),stateMgr);
    }        
    
    public synchronized short getShortValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetShortValue(stateMgr);
    }

    public synchronized void setShortValue(short newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetShortValue(newValue,stateMgr);
    }    
    
    public synchronized short getShortValue()
    {
        return getShortValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setShortValue(short newValue)
    {
        setShortValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetShortValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetShortValue(this.value,stateMgr);
    }    

    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetShortValue(((NativeShortImpl)detachedCopy).value,stateMgr);
    }       
    
    public Object jnieasyGetInternalValue()
    {
        return new Short(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Short)obj).shortValue();
    }
        
    public Object jnieasyNewInstance()
    {
        return new NativeShortImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeShortImpl[len];
    }     
        
}
