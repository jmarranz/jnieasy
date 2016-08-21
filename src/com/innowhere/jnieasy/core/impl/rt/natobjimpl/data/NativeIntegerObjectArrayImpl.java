/*
 * IntegerObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;


public class NativeIntegerObjectArrayImpl extends NativeNumberObjectArrayImpl implements NativeIntegerObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Integer[] value;
    
    /** Creates a new instance of IntegerObjectWrapperImpl */
    public NativeIntegerObjectArrayImpl()
    {
    } 
    
    public static NativeIntegerObjectArrayImpl newIntegerObjectArray()
    {
        return new NativeIntegerObjectArrayImpl();
    }      
    
   
    public void setIntegerArray(Integer[] newValue)
    {
        setObjectArray(newValue);
    }
    
    public Integer[] getIntegerArray()
    {
        return (Integer[])getObjectArray();
    }    
   
    public Integer getInteger(int index)
    {
        return (Integer)getElement(index);
    }
    
    public void setInteger(int index, Integer newValue)
    {
        setElement(index,newValue);        
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeIntegerObjectArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeIntegerObjectArrayImpl[len];
    }     
            
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Integer[])newValue;            
    }           
}
