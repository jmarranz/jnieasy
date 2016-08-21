/*
 * BooleanObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeBooleanObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Boolean objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Boolean object.
 * <p>
 * If native the corresponding native memory is a boolean (<code>jboolean</code>),
 * a Java reference of this type can be considered like a <code>jboolean*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeBooleanObject extends NativePrimitiveObject
{
    /**
     * Returns the internal Boolean object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Boolean object is null or native memory value
     * is different to the boolean value hold by this instance, a new
     * Boolean object is created, saved and returned, otherwise the
     * current object is returned.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Boolean)getValue();
     * </code></blockquote>
     *
     * @return the internal Boolean object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public Boolean getBoolean();
    
    /**
     * Sets the internal Boolean object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the boolean value
     * hold by the new Boolean value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */    
    public void setBoolean(Boolean value);    
}
