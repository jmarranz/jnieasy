/*
 * NativeArrayOfArrayImpl.java
 *
 * Created on 27 de diciembre de 2004, 13:32
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.data.*;


public abstract class NativeArrayOfArrayImpl extends CanBeNativeCapableArrayImpl implements NativeArrayOfArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeArrayOfArrayImpl
     */
    public NativeArrayOfArrayImpl()
    {
    }

}
