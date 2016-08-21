/*
 * ConstructorWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.method.*;
import java.lang.reflect.*;



public class NativeMethodReflectionArrayImpl extends NativeBehaviorReflectionArrayImpl implements NativeMethodReflectionArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected transient Method[] value;
    
    /** Creates a new instance of MethodReflectionWrapperImpl */
    public NativeMethodReflectionArrayImpl()
    {
    }   

    public static NativeMethodReflectionArrayImpl newMethodReflectionArray()
    {
        return new NativeMethodReflectionArrayImpl();
    }      

    public Method[] getMethodArray()
    {
        return (Method[])getObjectArray();
    }
    
    public void setMethodArray(Method[] newValue)
    {
        setObjectArray(newValue);
    }
        
    public Method getMethod(int index)
    {
        return (Method)getElement(index);
    }
    
    public void setMethod(int index, Method newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeMethodReflectionArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeMethodReflectionArrayImpl[len];
    }             
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Method[])newValue;            
    }           

}
