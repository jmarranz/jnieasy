/*
 * LongObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeLongObject</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.Long objects.
 * <p>
 * The framework has an internal class implementing this interface.
 * An instance contains (or must contain) a java.lang.Long object.
 * <p>
 * If native the corresponding native memory is a long (<code>jlong</code>),
 * a Java reference of this type can be considered like a <code>jlong*</code>
 * native variable.
 * <p>
 * This type can be declared as cross-platform using 
 * the method {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#decAddress()} 
 * and {@link com.innowhere.jnieasy.core.typedec.TypeNativePrimitive#decObjectWrapper(Class)} with NativeLongObject.class parameter,
 * or with the expression "NativeLongObject{address}" or with the "address" attribute
 * in XML declarations.   
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeLong
 */
public interface NativeLongObject extends NativeNumberObject
{
    /**
     * Returns the internal Long object synchronized 
     * with the native memory if instance is native.
     * <p>
     * If internal Long object is null or native memory value
     * is different to the long value hold by this instance, a new
     * Long object is created, saved and returned, otherwise the
     * current object is returned.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Long)getValue();
     * </code></blockquote>
     *
     * @return the internal Long object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */        
    public Long getLong();
    
    /**
     * Sets the internal Long object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * If native the native memory is updated with the long value
     * hold by the new Long value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setLong(Long value);    
}
