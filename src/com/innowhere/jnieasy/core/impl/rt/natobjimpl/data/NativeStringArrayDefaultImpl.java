/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */



// Equivale en C++ a: new char*[numItems]

public class NativeStringArrayDefaultImpl extends NativeStringArrayImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrString */
    public NativeStringArrayDefaultImpl()
    {
    }    

    public static NativeStringArrayDefaultImpl newStringArrayDefault()
    {
        return new NativeStringArrayDefaultImpl();
    }    
       
    public Object jnieasyNewInstance()
    {
        return new NativeStringArrayDefaultImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringArrayDefaultImpl[len];
    }     
        
}
