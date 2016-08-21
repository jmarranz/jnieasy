/*
 * CPPObject.java
 *
 * Created on 11 de febrero de 2004, 11:55
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;




/* Act�a como proxy �nicamente (retorno de una funci�n p.ej.), 
 */

public class NativePointerDefaultImpl extends NativePointerImpl 
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
    
    protected Object jnieasyPtr;
    
    /** Creates a new instance of CPPObject */
    public NativePointerDefaultImpl()
    {
    }

    public boolean jnieasyNeedAuxObjects()
    {
        // Si porque el puntero puede cambiar y puede necesitar el auxiliar
        return true; 
    }
    
    public Object jnieasyGetInternalValue()
    {
        return jnieasyPtr;
    }
    
    public void jnieasySetInternalValue(Object obj)
    {
        this.jnieasyPtr = obj;
    }
    
    public Object jnieasyNewInstance()
    {
        return new NativePointerDefaultImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativePointerDefaultImpl[len];
    }     
        
}
