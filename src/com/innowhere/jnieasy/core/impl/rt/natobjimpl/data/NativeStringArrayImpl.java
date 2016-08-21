/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;




// Equivale en C++ a: new char*[numItems] (o con wchar_t si UNICODE

public abstract class NativeStringArrayImpl extends CanBeNativeCapableArrayImpl implements NativeStringArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected String[] value;
    
    /** Creates a new instance of PtrString */
    public NativeStringArrayImpl()
    {
    }
    
    public String getString(int index)
    {
        return (String)getElement(index);
    }
    
    public void setString(int index, String newValue)
    {
        setElement(index,newValue);
    }
    
    public String[] getStringArray()
    {
        return (String[])getObjectArray();
    }
    
    public void setStringArray(String[] newValue)
    {
        setObjectArray(newValue);
    }
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (String[])newValue;            
    }    

}
