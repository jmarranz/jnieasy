/*
 * DoubleObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;


public class NativeDoubleObjectArrayImpl extends NativeNumberObjectArrayImpl implements NativeDoubleObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Double[] value;
    
    /** Creates a new instance of DoubleObjectWrapperImpl */
    public NativeDoubleObjectArrayImpl()
    {
    }   

    public static NativeDoubleObjectArrayImpl newDoubleObjectArray()
    {
        return new NativeDoubleObjectArrayImpl();
    }      
    
    public void setDoubleArray(Double[] newValue)
    {
        setValue(newValue);
    }
    
    public Double[] getDoubleArray()
    {
        return (Double[])getObjectArray();
    }
    
    public Double getDouble(int index)
    {
        return (Double)getElement(index);
    }
    
    public void setDouble(int index, Double newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeDoubleObjectArrayImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeDoubleObjectArrayImpl[len];
    }     
            
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Double[])newValue;            
    }           
}
