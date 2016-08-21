/*
 * NativePrimitiveImpl.java
 *
 * Created on 15 de octubre de 2004, 12:02
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNative;


public abstract class NativePrimitiveImpl extends NativeSingleFieldContainerImpl implements NativePrimitive
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativePrimitiveImpl 
     */
    public NativePrimitiveImpl()
    {
    }
    
    public TypeNativePrimitiveRuntimeImpl jnieasyGetFieldTypeNativePrimitive()
    {
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)jnieasyGetType();
        return typeDec.getypeNativePrimitiveRuntime();
    }    
    
    public long jnieasyGetSize()
    {
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)jnieasyGetType();
        return typeDec.size();
    }        
    
    public TypeNative jnieasyGetDefaultType()
    {
        RuntimeContext ctx = jnieasyGetDefaultRuntimeContext();
        return TypeNativeRuntimeImpl.newTypeNativeRuntime(getClass(),ctx);         
    }
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativePrimitiveStateManagerImpl();
    }
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        // no hay fields detachables
    }      
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // se clona por si mismo
    }    

    
}
