/*
 * ShortObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeShortObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Short objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Short object.
 * <p>
 * If native the corresponding native memory is a short (<code>jshort</code>),
 * a Java reference of this type can be considered like a <code>jshort*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeShortObject extends NativeNumberObject
{
    /**
     * Returns the internal Short object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Short object is null or native memory value
     * is different to the short value hold by this instance, a new
     * Short object is created, saved and returned, otherwise the
     * current object is returned.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Short)getValue();
     * </code></blockquote>
     *
     * @return the internal Short object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */        
    public Short getShort();
    
    /**
     * Sets the internal Short object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the short value
     * hold by the new Short value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setShort(Short value);    
}
