/*
 * LongObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeLongObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Long.
 * <p>
 * A Long Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jlong</code> pointer array 
 * because Long objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeLongObjectArray extends NativeNumberObjectArray
{
    /**
     * Returns the Long element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Long)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Long element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Long getLong(int index);
    
    /**
     * Sets the Long element at the specified index synchronizing
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
    public void setLong(int index,Long value);    
    
    /**
     * Returns the internal Long array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Long[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Long array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Long[] getLongArray();
    
    /**
     * Sets the internal Long array synchronizing
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
    public void setLongArray(Long[] value);   
}
