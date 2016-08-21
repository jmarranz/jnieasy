/*
 * PrimitiveObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:47
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;


public abstract class NativePrimitiveObjectArrayImpl extends CanBeNativeCapableArrayImpl implements NativePrimitiveObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PrimitiveObjectWrapperImpl */
    public NativePrimitiveObjectArrayImpl()
    {
    }

}
