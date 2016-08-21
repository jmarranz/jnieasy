/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;


// Equivale en C++ a: new wchar_t*[numItems]

public class NativeStringUnicodeArrayImpl extends NativeStringArrayImpl implements NativeStringUnicodeArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrString */
    public NativeStringUnicodeArrayImpl()
    {
    }    

    public static NativeStringUnicodeArrayImpl newStringUnicodeArray()
    {
        return new NativeStringUnicodeArrayImpl();
    }    
       
    public Object jnieasyNewInstance()
    {
        return new NativeStringUnicodeArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringUnicodeArrayImpl[len];
    }     
        
}
