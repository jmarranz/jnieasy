/*
 * CharacterObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeCharacterObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Character.
 * <p>
 * A Character Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jchar</code> pointer array 
 * because Character objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeCharacterObjectArray extends NativePrimitiveObjectArray
{
    /**
     * Returns the Character element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Character)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Character element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Character getCharacter(int index);
    
    /**
     * Sets the Character element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setObject(index,value);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     */     
    public void setCharacter(int index,Character value);  
    
    /**
     * Returns the internal Character array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Character[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Character array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Character[] getCharacterArray();
    
    /**
     * Sets the internal Character array synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setObjectArray(value);
     * </code></blockquote>
     *
     * @param value the new array value.
     * @see NativeObjectArray#setObjectArray(Object[])
     */        
    public void setCharacterArray(Character[] value);   
}
