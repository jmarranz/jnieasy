/*
 * CharacterObjectWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;


public class NativeCharacterObjectArrayImpl extends NativePrimitiveObjectArrayImpl implements NativeCharacterObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Character[] value;
    
    /** Creates a new instance of CharacterObjectWrapperImpl */
    public NativeCharacterObjectArrayImpl()
    {
    }   

    public static NativeCharacterObjectArrayImpl newCharacterObjectArray()
    {
        return new NativeCharacterObjectArrayImpl();
    }      
    
    public void setCharacterArray(Character[] newValue)
    {
        setValue(newValue);
    }
    
    public Character[] getCharacterArray()
    {
        return (Character[])getObjectArray();
    }
    
    public Character getCharacter(int index)
    {
        return (Character)getElement(index);
    }
    
    public void setCharacter(int index, Character newValue)
    {
        setElement(index,newValue);
    } 
   
    public Object jnieasyNewInstance()
    {
        return new NativeCharacterObjectArrayImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeCharacterObjectArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Character[])newValue;            
    }           
    
}
