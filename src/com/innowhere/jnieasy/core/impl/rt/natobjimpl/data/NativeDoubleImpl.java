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
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;




public class NativeDoubleImpl extends NativeNumberImpl implements NativeDouble
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected double value;
    
    /** Creates a new instance of PtrInteger */

    public NativeDoubleImpl()
    {
    }

    public TypeNativeDoubleRuntimeImpl jnieasyGetFieldTypeNativeDouble()
    {
        return (TypeNativeDoubleRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }
    
    public double jnieasyGetDoubleValue(NativeStateManager stateMgr)
    {
        TypeNativeDoubleRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeDouble();
        this.value = typeDecField.getFieldDouble(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);

        return this.value;
    }

    public void jnieasySetDoubleValue(double newValue,NativeStateManager stateMgr)
    {
        TypeNativeDoubleRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeDouble();
        typeDecField.setFieldDouble(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Double(jnieasyGetDoubleValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetDoubleValue(((Double)newValue).doubleValue(),stateMgr);
    }        
    
    public synchronized double getDoubleValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetDoubleValue(stateMgr);
    }

    public synchronized void setDoubleValue(double newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetDoubleValue(newValue,stateMgr);
    }    
        

    public synchronized double getDoubleValue()
    {
        return getDoubleValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setDoubleValue(double newValue)
    {
        setDoubleValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetDoubleValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetDoubleValue(this.value,stateMgr);
    }    

    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetDoubleValue(((NativeDoubleImpl)detachedCopy).value,stateMgr);
    }   
    
    public Object jnieasyGetInternalValue()
    {
        return new Double(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Double)obj).doubleValue();
    }
        
    public Object jnieasyNewInstance()
    {
        return new NativeDoubleImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeDoubleImpl[len];
    }     
        
}
