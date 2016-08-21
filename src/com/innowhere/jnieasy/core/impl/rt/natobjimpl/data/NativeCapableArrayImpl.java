/*
 * NativeCapableArrayImpl.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;


public abstract class NativeCapableArrayImpl extends NativeObjectArrayImpl implements NativeCapableArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
   
    /** Creates a new instance of NativeCapableArrayImpl */
    
    public NativeCapableArrayImpl()
    {
    }

    public boolean jnieasyNeedAuxObjects()
    {
        return false; // Los elementos del array son NativeCapable por s� mismos
    }    
}
