/*
 * StringBasedImpl.java
 *
 * Created on 17 de marzo de 2005, 18:43
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerDefaultImpl;



public abstract class StringBasedImpl extends CanBeNativeCapableImpl implements NativeStringBased
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of StringBasedImpl
     */
    public StringBasedImpl()
    {
    }
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativeObjectFieldContainerStateManagerDefaultImpl();    
    }
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        // no hay fields detachables
    }
    
    public abstract long getCharSize();    

    public boolean jnieasyNeedAuxObjects()
    {
        return false;
    }    
}
