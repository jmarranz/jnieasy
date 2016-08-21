/*
 * CPPObject.java
 *
 * Created on 11 de febrero de 2004, 11:55
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;


/* Actúa como proxy únicamente (retorno de una función p.ej.), 
 */

public class CPPClassDefaultImpl extends NativeSeparatedFieldContainerImpl implements CPPClass
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of CPPObject */
    public CPPClassDefaultImpl()
    {
    }        
   
    public Object jnieasyNewInstance()
    {
        return new CPPClassDefaultImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new CPPClassDefaultImpl[len];
    }     
    
}
