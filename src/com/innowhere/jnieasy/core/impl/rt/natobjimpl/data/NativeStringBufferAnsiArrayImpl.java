/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;


// Equivale en C++ a: new char*[numItems]

public class NativeStringBufferAnsiArrayImpl extends NativeStringBufferArrayImpl implements NativeStringBufferAnsiArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos
    
    /** Creates a new instance of PtrString */
    public NativeStringBufferAnsiArrayImpl()
    {
    }    

    public static NativeStringBufferAnsiArrayImpl newStringBufferAnsiArray()
    {
        return new NativeStringBufferAnsiArrayImpl();
    }    
   
    public Object jnieasyNewInstance()
    {
        return new NativeStringBufferAnsiArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringBufferAnsiArrayImpl[len];
    }     
        
}
