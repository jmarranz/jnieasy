/*
 * FloatObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;


public class NativeFloatObjectArrayImpl extends NativeNumberObjectArrayImpl implements NativeFloatObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Float[] value;
    
    /** Creates a new instance of FloatObjectWrapperImpl */
    public NativeFloatObjectArrayImpl()
    {
    }   
    
    public static NativeFloatObjectArrayImpl newFloatObjectArray()
    {
        return new NativeFloatObjectArrayImpl();
    }      
    
    public void setFloatArray(Float[] newValue)
    {
        setValue(newValue);
    }
    
    public Float[] getFloatArray()
    {
        return (Float[])getObjectArray();
    }
    
    public Float getFloat(int index)
    {
        return (Float)getElement(index);
    }
    
    public void setFloat(int index, Float newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeFloatObjectArrayImpl();
    }    
        
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeFloatObjectArrayImpl[len];
    }        
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Float[])newValue;            
    }           
}
