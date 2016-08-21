/*
 * ShortObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeShortObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Short.
 * <p>
 * A Short Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a jshort pointer array 
 * because Short objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeShortObjectArray extends NativeNumberObjectArray
{
    /**
     * Returns the Short element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Short)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Short element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Short getShort(int index);
    
    /**
     * Sets the Short element at the specified index synchronizing
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
    public void setShort(int index,Short value);  
    
    /**
     * Returns the internal Short array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Short[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Short array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Short[] getShortArray();
    
    /**
     * Sets the internal Short array synchronizing
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
    public void setShortArray(Short[] value);   
}
