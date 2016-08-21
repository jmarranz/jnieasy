/*
 * ByteObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeByteObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Byte objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Byte object.
 * <p>
 * If native the corresponding native memory is a byte (<code>jbyte</code>),
 * a Java reference of this type can be considered like a <code>jbyte*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeByteObject extends NativeNumberObject
{
    /**
     * Returns the internal Byte object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Byte object is null or native memory value
     * is different to the byte value hold by this instance, a new
     * Byte object is created, saved and returned, otherwise the
     * current object is returned.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Byte)getValue();
     * </code></blockquote>
     *
     * @return the internal Byte object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */       
    public Byte getByte();
    
    /**
     * Sets the internal Byte object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the byte value
     * hold by the new Byte value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setByte(Byte value);    
}
