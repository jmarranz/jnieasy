/*
 * NativeNumberImpl.java
 *
 * Created on 3 de febrero de 2005, 11:15
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.mem.*;

public abstract class NativeNumberImpl extends NativePrimitiveImpl implements NativeNumber
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeNumberImpl 
     */
    public NativeNumberImpl()
    {
    }

}
