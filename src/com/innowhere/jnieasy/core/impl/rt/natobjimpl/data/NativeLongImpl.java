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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeLongImpl extends NativeNumberImpl implements NativeLong
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected long value;
    
    /** Creates a new instance of PtrInteger */   
    public NativeLongImpl()
    {
    }
     
    public TypeNativeLongRuntimeImpl jnieasyGetFieldTypeNativeLong()
    {
        return (TypeNativeLongRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }    
            
    public long jnieasyGetLongValue(NativeStateManager stateMgr)
    {
        TypeNativeLongRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeLong();
        this.value = typeDecField.getFieldLong(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        return this.value;        
    }

    public void jnieasySetLongValue(long newValue,NativeStateManager stateMgr)
    {
        TypeNativeLongRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeLong();
        typeDecField.setFieldLong(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);        
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Long(jnieasyGetLongValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetLongValue(((Long)newValue).longValue(),stateMgr);
    }        
    
    public synchronized long getLongValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetLongValue(stateMgr);
    }

    public synchronized void setLongValue(long newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetLongValue(newValue,stateMgr);
    }    
        
    
    public synchronized long getLongValue()
    {
        return getLongValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setLongValue(long newValue)
    {
        setLongValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
   
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetLongValue(stateMgr);
    }

    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetLongValue(this.value,stateMgr);
    }    
    
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetLongValue(((NativeLongImpl)detachedCopy).value,stateMgr);
    }    
    
    public Object jnieasyGetInternalValue()
    {
        return new Long(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Long)obj).longValue();
    }
    
    public Object jnieasyNewInstance()
    {
        return new NativeLongImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeLongImpl[len];
    }        

}
