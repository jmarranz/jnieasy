/*
 * ByteObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */


import com.innowhere.jnieasy.core.data.*;


public class NativeByteObjectArrayImpl extends NativeNumberObjectArrayImpl implements NativeByteObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Byte[] value;
    
    /** Creates a new instance of ByteObjectWrapperImpl */
    public NativeByteObjectArrayImpl()
    {
    }   

    public static NativeByteObjectArrayImpl newByteObjectArray()
    {
        return new NativeByteObjectArrayImpl();
    }      

    
    public void setByteArray(Byte[] newValue)
    {
        setValue(newValue);
    }
    
    public Byte[] getByteArray()
    {
        return (Byte[])getObjectArray();
    }
    
    public Byte getByte(int index)
    {
        return (Byte)getElement(index);
    }
    
    public void setByte(int index, Byte newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeByteObjectArrayImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeByteObjectArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Byte[])newValue;            
    }           
}
