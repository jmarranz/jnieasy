/*
 * NativeCapableDefaultImpl.java
 *
 * Created on 30 de octubre de 2004, 14:04
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNative;



public class NativeCapableDefaultImpl extends NativeCapableImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeCapableDefaultImpl 
     */
    public NativeCapableDefaultImpl()
    {
    }    
    
    public long jnieasyGetSize()
    {
        return TypeSizes.getUNKNOWN_SIZE(); // desconocido
    }
    
    public TypeNative jnieasyGetDefaultType()
    {
        RuntimeContext ctx = jnieasyGetDefaultRuntimeContext();
        return TypeNativeRuntimeImpl.newTypeNativeRuntime(getClass(),ctx);        
    }
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // fields desconocidos
    }
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativeStateManagerDefaultImpl();        
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeCapableDefaultImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeCapableDefaultImpl[len];
    }     
    
}
