/*
 * CPPObject.java
 *
 * Created on 11 de febrero de 2004, 11:55
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;


/* Act�a como proxy �nicamente (retorno de una funci�n p.ej.), 
 */

public class UnionDefaultImpl extends NativeMultipleFieldContainerImpl implements Union
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
    
    /** Creates a new instance of CPPObject */
    public UnionDefaultImpl()
    {
    }        
   
    public Object jnieasyNewInstance()
    {
        return new UnionDefaultImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new UnionDefaultImpl[len];
    }     
    
}
