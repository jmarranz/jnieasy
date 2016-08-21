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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeBooleanImpl extends NativePrimitiveImpl implements NativeBoolean
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected boolean value;
    
    /** Creates a new instance of PtrInteger */

    public NativeBooleanImpl()
    {
    }
    
    public TypeNativeBooleanRuntimeImpl jnieasyGetFieldTypeNativeBoolean()
    {
        return (TypeNativeBooleanRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }  
    
    public boolean jnieasyGetBooleanValue(NativeStateManager stateMgr)
    {
        TypeNativeBooleanRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeBoolean();
        this.value = typeDecField.getFieldBoolean(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        return this.value;        
    }

    public void jnieasySetBooleanValue(boolean newValue,NativeStateManager stateMgr)
    {
        TypeNativeBooleanRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeBoolean();
        typeDecField.setFieldBoolean(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return Boolean.valueOf(jnieasyGetBooleanValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetBooleanValue(((Boolean)newValue).booleanValue(),stateMgr);
    }        
    
    public synchronized boolean getBooleanValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetBooleanValue(stateMgr);
    }

    public synchronized void setBooleanValue(boolean newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetBooleanValue(newValue,stateMgr);
    }    
    
    public synchronized boolean getBooleanValue()
    {
        return getBooleanValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setBooleanValue(boolean newValue)
    {
        setBooleanValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }

    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetBooleanValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetBooleanValue(this.value,stateMgr);
    }    

    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetBooleanValue(((NativeBooleanImpl)detachedCopy).value,stateMgr);
    }
    
    public Object jnieasyGetInternalValue()
    {
        return Boolean.valueOf(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Boolean)obj).booleanValue();
    }

            
    public Object jnieasyNewInstance()
    {
        return new NativeBooleanImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeBooleanImpl[len];
    }     
        
}
