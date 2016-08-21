/*
 * ConstructorWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

/**
 *
 * @author  jmarranz
 */
import java.lang.reflect.*;

import com.innowhere.jnieasy.core.method.*;


public class NativeConstructorReflectionArrayImpl extends NativeBehaviorReflectionArrayImpl implements NativeConstructorReflectionArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected transient Constructor[] value;
    
    /** Creates a new instance of ConstructorWrapperImpl */
    public NativeConstructorReflectionArrayImpl()
    {
    }   

    public static NativeConstructorReflectionArrayImpl newConstructorReflectionArray()
    {
        return new NativeConstructorReflectionArrayImpl();
    }      

    public Constructor[] getConstructorArray()
    {
        return (Constructor[])getObjectArray();
    }
        
    public void setConstructorArray(Constructor[] newValue)
    {
        setObjectArray(newValue);
    }

    public Constructor getConstructor(int index)
    {
        return (Constructor)getElement(index);
    }
    
    public void setConstructor(int index, Constructor newValue)
    {
        setElement(index,newValue);        
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeConstructorReflectionArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeConstructorReflectionArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Constructor[])newValue;            
    }           
 
}
