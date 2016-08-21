/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;


// Equivale en C++ a: new char*[numItems]

public class NativeStringAnsiArrayImpl extends NativeStringArrayImpl implements NativeStringAnsiArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrString */
    public NativeStringAnsiArrayImpl()
    {
    }    

    public static NativeStringAnsiArrayImpl newStringAnsiArray()
    {
        return new NativeStringAnsiArrayImpl();
    }    
       
    public Object jnieasyNewInstance()
    {
        return new NativeStringAnsiArrayImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringAnsiArrayImpl[len];
    }     
        
}
