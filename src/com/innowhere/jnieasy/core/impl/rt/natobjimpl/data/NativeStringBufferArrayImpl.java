/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;




// Equivale en C++ a: new char*[numItems] (o con wchar_t si UNICODE

public abstract class NativeStringBufferArrayImpl extends CanBeNativeCapableArrayImpl implements NativeStringBufferArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected StringBuffer[] value;
    
    /** Creates a new instance of PtrString */
    public NativeStringBufferArrayImpl()
    {
    }
       
    public StringBuffer getStringBuffer(int index)
    {
        return (StringBuffer)getElement(index);
    }
    
    public void setStringBuffer(int index, StringBuffer newValue)
    {
        setElement(index,newValue);
    }
       
    public StringBuffer[] getStringBufferArray()
    {
        return (StringBuffer[])getObjectArray();
    }
    
    public void setStringBufferArray(StringBuffer[] newValue)
    {
        setObjectArray(newValue);
    }
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (StringBuffer[])newValue;            
    }
  
}
