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
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
    
    /** Creates a new instance of PrimitiveObjectWrapperImpl */
    public NativePrimitiveObjectArrayImpl()
    {
    }

}
