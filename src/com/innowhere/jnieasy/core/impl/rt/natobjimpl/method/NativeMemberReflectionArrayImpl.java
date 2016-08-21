/*
 * NativeMemberReflectionArrayImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:47
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.*;
import com.innowhere.jnieasy.core.data.NativeMemberReflectionArray;


public abstract class NativeMemberReflectionArrayImpl extends CanBeNativeCapableArrayImpl implements NativeMemberReflectionArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of NativeMemberReflectionArrayImpl */
    public NativeMemberReflectionArrayImpl()
    {
    }

}
