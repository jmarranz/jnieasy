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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeFloatImpl extends NativeNumberImpl implements NativeFloat
{   
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected float value;
    
    /** Creates a new instance of PtrInteger */
    public NativeFloatImpl()
    {
    }
        
    public TypeNativeFloatRuntimeImpl jnieasyGetFieldTypeNativeFloat()
    {
        return (TypeNativeFloatRuntimeImpl)this.jnieasyGetFieldTypeNativePrimitive();
    }  
    
    public float jnieasyGetFloatValue(NativeStateManager stateMgr)
    {
        TypeNativeFloatRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeFloat();
        this.value = typeDecField.getFieldFloat(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        return this.value;
    }

    public void jnieasySetFloatValue(float newValue,NativeStateManager stateMgr)
    {
        TypeNativeFloatRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeFloat();
        typeDecField.setFieldFloat(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Float(jnieasyGetFloatValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetFloatValue(((Float)newValue).floatValue(),stateMgr);
    }        
    
    public synchronized float getFloatValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetFloatValue(stateMgr);
    }

    public synchronized void setFloatValue(float newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetFloatValue(newValue,stateMgr);
    }        
    
    
    public synchronized float getFloatValue()
    {
        return getFloatValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setFloatValue(float newValue)
    {
        setFloatValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }

    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetFloatValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetFloatValue(this.value,stateMgr);
    }   
        
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetFloatValue(((NativeFloatImpl)detachedCopy).value,stateMgr);
    }        
    
    public Object jnieasyGetInternalValue()
    {
        return new Float(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Float)obj).floatValue();
    }
        
    public Object jnieasyNewInstance()
    {
        return new NativeFloatImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeFloatImpl[len];
    }     
}
