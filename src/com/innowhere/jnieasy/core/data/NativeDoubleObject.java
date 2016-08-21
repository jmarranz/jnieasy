/*
 * DoubleObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeDoubleObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Double objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Double object.
 * <p>
 * If native the corresponding native memory is a double (<code>jdouble</code>),
 * a Java reference of this type can be considered like a <code>jdouble*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeDoubleObject extends NativeNumberObject
{
    /**
     * Returns the internal Double object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Double object is null or native memory value
     * is different to the double value hold by this instance, a new
     * Double object is created, saved and returned, otherwise the
     * current object is returned.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Double)getValue();
     * </code></blockquote>
     *
     * @return the internal Double object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */        
    public Double getDouble();
    
    /**
     * Sets the internal Double object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the double value
     * hold by the new Double value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setDouble(Double value);    
}
