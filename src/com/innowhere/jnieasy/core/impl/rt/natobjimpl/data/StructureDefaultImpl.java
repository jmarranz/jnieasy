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


/* Act�a como proxy �nicamente (retorno de una funci�n p.ej.), 
 */

public class StructureDefaultImpl extends NativeSeparatedFieldContainerImpl implements Structure
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
    
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
