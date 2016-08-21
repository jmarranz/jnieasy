/*
 * NativeFieldMethodReflectionArrayImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.method.NativeFieldMethodReflectionArray;
import java.lang.reflect.*;




public class NativeFieldMethodReflectionArrayImpl extends NativeMemberReflectionArrayImpl implements NativeFieldMethodReflectionArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected transient Field[] value;
    
    /**
     * Creates a new instance of NativeFieldMethodReflectionArrayImpl
     */
    public NativeFieldMethodReflectionArrayImpl()
    {
    }   

    public static NativeFieldMethodReflectionArrayImpl newFieldMethodReflectionArray()
    {
        return new NativeFieldMethodReflectionArrayImpl();
    }      

    public Field[] getFieldArray()
    {
        return (Field[])getObjectArray();
    }

    public void setFieldArray(Field[] newValue)
    {
        setObjectArray(newValue);
    }
        
    public Field getField(int index)
    {
        return (Field)getElement(index);
    }
    
    public void setField(int index, Field newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeFieldMethodReflectionArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeFieldMethodReflectionArrayImpl[len];
    }     
            
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Field[])newValue;            
    }           
}
