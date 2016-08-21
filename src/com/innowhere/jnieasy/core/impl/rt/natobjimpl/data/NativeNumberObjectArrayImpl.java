/*
 * NativeNumberObjectArrayImpl.java
 *
 * Created on 3 de febrero de 2005, 11:11
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;


public abstract class NativeNumberObjectArrayImpl extends NativePrimitiveObjectArrayImpl implements NativeNumberObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
    
    /**
     * Creates a new instance of NativeNumberObjectArrayImpl
     */
    public NativeNumberObjectArrayImpl()
    {
    }

}
