/*
 * CanBeNativeCapableArray.java
 *
 * Created on 4 de diciembre de 2004, 12:11
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;


public abstract class CanBeNativeCapableArrayImpl extends NativeObjectArrayImpl implements CanBeNativeCapableArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
   
    /**
     * Creates a new instance of CanBeNativeCapableArray
     */
    public CanBeNativeCapableArrayImpl()
    {
    }

    public boolean jnieasyNeedAuxObjects()
    {
        return true;
    }
}
