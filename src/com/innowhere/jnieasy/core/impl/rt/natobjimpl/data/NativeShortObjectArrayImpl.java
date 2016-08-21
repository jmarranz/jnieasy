/*
 * ShortObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;


public class NativeShortObjectArrayImpl extends NativeNumberObjectArrayImpl implements NativeShortObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Short[] value;
    
    /** Creates a new instance of ShortObjectWrapperImpl */
    public NativeShortObjectArrayImpl()
    {
    }  

    public static NativeShortObjectArrayImpl newShortObjectArray()
    {
        return new NativeShortObjectArrayImpl();
    }      

    public void setShortArray(Short[] newValue)
    {
        setValue(newValue);
    }
    
    public Short[] getShortArray()
    {
        return (Short[])getObjectArray();
    }
    
    public Short getShort(int index)
    {
        return (Short)getElement(index);
    }
    
    public void setShort(int index, Short newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeShortObjectArrayImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeShortObjectArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Short[])newValue;            
    }           
}
