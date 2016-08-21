/*
 * CPPObject.java
 *
 * Created on 11 de febrero de 2004, 11:55
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.impl.mem.*;


/* Actúa como proxy únicamente (retorno de una función p.ej.), 
 */

public class StructureDefaultImpl extends NativeSeparatedFieldContainerImpl implements Structure
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of CPPObject */
    public StructureDefaultImpl()
    {
    }
   
    public Object jnieasyNewInstance()
    {
        return new StructureDefaultImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new StructureDefaultImpl[len];
    }     
        
}
