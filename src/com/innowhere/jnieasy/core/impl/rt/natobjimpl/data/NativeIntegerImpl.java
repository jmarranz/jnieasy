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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeIntegerImpl extends NativeNumberImpl implements NativeInteger
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected int value;
    
    /** Creates a new instance of PtrInteger */
    public NativeIntegerImpl()
    {
    }
        
    public TypeNativeIntegerRuntimeImpl jnieasyGetFieldTypeNativeInteger()
    {
        return (TypeNativeIntegerRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }
    
    public int jnieasyGetIntValue(NativeStateManager stateMgr)
    {
        TypeNativeIntegerRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeInteger();
        this.value = typeDecField.getFieldInt(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);

        return this.value;
    }

    public void jnieasySetIntValue(int newValue,NativeStateManager stateMgr)
    {
        TypeNativeIntegerRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeInteger();
        typeDecField.setFieldInt(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Integer(jnieasyGetIntValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetIntValue(((Integer)newValue).intValue(),stateMgr);
    }        
    
    public synchronized int getIntValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetIntValue(stateMgr);
    }

    public synchronized void setIntValue(int newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetIntValue(newValue,stateMgr);
    }    
        
    
    public synchronized int getIntValue()
    {
        return getIntValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setIntValue(int newValue)
    {
        setIntValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }

    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetIntValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetIntValue(this.value,stateMgr);
    }    

    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetIntValue(((NativeIntegerImpl)detachedCopy).value,stateMgr);
    }
    
    public Object jnieasyGetInternalValue()
    {
        return new Integer(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Integer)obj).intValue();
    }
        
    public Object jnieasyNewInstance()
    {
        return new NativeIntegerImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeIntegerImpl[len];
    } 

}
