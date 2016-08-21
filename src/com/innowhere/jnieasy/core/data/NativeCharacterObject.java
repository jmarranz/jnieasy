/*
 * CharacterObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeCharacterObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Character objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Character object.
 * <p>
 * If native the corresponding native memory is a char (<code>jchar</code>),
 * a Java reference of this type can be considered like a <code>jchar*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeCharacterObject extends NativePrimitiveObject
{
    /**
     * Returns the internal Character object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Character object is null or native memory value
     * is different to the character value hold by this instance, a new
     * Character object is created, saved and returned, otherwise the
     * current object is returned.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Character)getValue();
     * </code></blockquote>
     *
     * @return the internal Character object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */      
    public Character getCharacter();
    
    /**
     * Sets the internal Character object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the character value
     * hold by the new Character value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */       
    public void setCharacter(Character value);    
}
