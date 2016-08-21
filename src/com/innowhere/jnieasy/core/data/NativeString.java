/*
 * NativeString.java
 *
 * Created on 26 de febrero de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeString</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.String objects.
 * <p>
 * The framework defines an internal native class supporting ANSI and
 * UNICODE encodings/sizes.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeString extends NativeStringBased
{
    /**
     * Returns the internal String object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal String object is null or native memory value
     * is different to the String value hold by this instance, a new
     * String object is created, saved and returned, otherwise the
     * current object is returned.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (String)getValue();
     * </code></blockquote>
     *
     * @return the internal String object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public String getString();
    
    /**
     * Sets the internal String object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setString(String value);
}
