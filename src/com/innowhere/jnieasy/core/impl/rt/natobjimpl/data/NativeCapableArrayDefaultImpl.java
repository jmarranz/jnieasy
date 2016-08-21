/*
 * NativeCapableArrayDefaultImpl.java
 *
 * Created on 14 de marzo de 2005, 17:12
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.NativeCapable;

public class NativeCapableArrayDefaultImpl extends NativeCapableArrayImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Object[] value; // No usamos NativeCapable[] para poder deserializar una colección de objetos de clase custom pero no enhanced (caso de RMI p.ej.)
    
    /**
     * Creates a new instance of NativeCapableArrayDefaultImpl 
     */
    public NativeCapableArrayDefaultImpl()
    {
    }

    public Object jnieasyNewInstance()
    {
        return new NativeCapableArrayDefaultImpl();
    }    
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeCapableArrayDefaultImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Object[])newValue;   /*(NativeCapable[])*/          
    }           

}
