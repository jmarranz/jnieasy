/*
 * LongObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;


public class NativeLongObjectArrayImpl extends NativeNumberObjectArrayImpl implements NativeLongObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Long[] value;
    
    /** Creates a new instance of LongObjectWrapperImpl */
    public NativeLongObjectArrayImpl()
    {
    }   
    
    public static NativeLongObjectArrayImpl newLongObjectArray()
    {
        return new NativeLongObjectArrayImpl();
    }      
    
    public void setLongArray(Long[] newValue)
    {
        setValue(newValue);
    }
    
    public Long[] getLongArray()
    {
        return (Long[])getObjectArray();
    }
    
    public Long getLong(int index)
    {
        return (Long)getElement(index);
    }
    
    public void setLong(int index, Long newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeLongObjectArrayImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeLongObjectArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Long[])newValue;            
    }           
}
