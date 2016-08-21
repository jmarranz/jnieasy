/*
 * IntegerObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeIntegerObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Integer objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Integer object.
 * <p>
 * If native the corresponding native memory is an int (<code>jint</code>),
 * a Java reference of this type can be considered like a <code>jint*</code>
 * native variable.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeIntegerObject extends NativeNumberObject
{
    /**
     * Returns the internal Integer object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Integer object is null or native memory value
     * is different to the integer value hold by this instance, a new
     * Integer object is created, saved and returned, otherwise the
     * current object is returned.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Integer)getValue();
     * </code></blockquote>
     *
     * @return the internal Integer object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */       
    public Integer getInteger();
    
    /**
     * Sets the internal Integer object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the integer value
     * hold by the new Integer value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setInteger(Integer value);    
}
