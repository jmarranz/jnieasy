/*
 * BooleanObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;



public class NativeBooleanObjectArrayImpl extends NativePrimitiveObjectArrayImpl implements NativeBooleanObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Boolean[] value;
    
    /** Creates a new instance of BooleanObjectWrapperImpl */
    public NativeBooleanObjectArrayImpl()
    {
    }   

    public static NativeBooleanObjectArrayImpl newBooleanObjectArray()
    {
        return new NativeBooleanObjectArrayImpl();
    }      
    
    public Boolean[] getBooleanArray()
    {
        return (Boolean[])getObjectArray();
    }
    
    public void setBooleanArray(Boolean[] newValue)
    {
        setObjectArray(newValue);
    }
    
    public Boolean getBoolean(int index)
    {
        return (Boolean)getElement(index);
    }
    
    public void setBoolean(int index, Boolean newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeBooleanObjectArrayImpl();
    }        
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeBooleanObjectArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Boolean[])newValue;            
    }           
}
