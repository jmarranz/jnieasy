/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveObjectWrapperRuntimeImpl;

public abstract class NativePrimitiveObjectImpl extends CanBeNativeCapableImpl implements NativePrimitiveObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrByte */
    public NativePrimitiveObjectImpl()
    {
    }
  
    public long jnieasyCalcSize(Object newValue)
    {
        return jnieasyGetSize(); // es fijo
    }
  
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativeObjectFieldContainerStateManagerDefaultImpl();    
    }
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        // no hay fields detachables
    }  

    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // no hay fields para clonar (son de solo lectura no merece la pena aunque se pudiera)
    }
    
    public boolean jnieasyNeedAuxObjects()
    {
        return false;
    }
    
    public Object jnieasyCloneValue(Object valueToClone,Object cloneCtx,NativeStateManager stateMgr)
    {
        // No son necesario clonarlo porque los primitive wrappers son de sólo lectura
        return valueToClone;
    }
    
    public TypeNativePrimitiveObjectRuntimeImpl jnieasyGetTypeNativePrimitiveObject()
    {
        TypeNativePrimitiveObjectWrapperRuntimeImpl typeDec = (TypeNativePrimitiveObjectWrapperRuntimeImpl)jnieasyGetType();
        return typeDec.getTypeNativePrimitiveObjectRuntime();
    }   
    
    public TypeNativePrimitiveRuntimeImpl jnieasyGetTypeNativePrimitive()
    {
        TypeNativePrimitiveObjectRuntimeImpl typeDec = jnieasyGetTypeNativePrimitiveObject();
        return typeDec.getTypeNativePrimitiveRuntime();
    }    
}
