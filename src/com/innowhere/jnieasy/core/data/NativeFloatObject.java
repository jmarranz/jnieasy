/*
 * FloatObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeFloatObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Float objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Float object.
 * <p>
 * If native the corresponding native memory is a float (<code>jfloat</code>),
 * a Java reference of this type can be considered like a <code>jfloat*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeFloatObject extends NativeNumberObject
{
    /**
     * Returns the internal Float object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Float object is null or native memory value
     * is different to the float value hold by this instance, a new
     * Float object is created, saved and returned, otherwise the
     * current object is returned.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Float)getValue();
     * </code></blockquote>
     *
     * @return the internal Float object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */      
    public Float getFloat();
    
    /**
     * Sets the internal Float object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the float value
     * hold by the new Float value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */    
    public void setFloat(Float value);    
}
