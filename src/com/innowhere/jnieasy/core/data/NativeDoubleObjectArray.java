/*
 * DoubleObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeDoubleObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Double.
 * <p>
 * A Double Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jdouble</code> pointer array 
 * because Double objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeDoubleObjectArray extends NativeNumberObjectArray
{
    /**
     * Returns the Double element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Double)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Double element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Double getDouble(int index);
    
    /**
     * Sets the Double element at the specified index synchronizing
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
    public void setDouble(int index,Double value); 
    
    /**
     * Returns the internal Double array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Double[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Double array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Double[] getDoubleArray();
    
    /**
     * Sets the internal Double array synchronizing
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
    public void setDoubleArray(Double[] value);   
}
