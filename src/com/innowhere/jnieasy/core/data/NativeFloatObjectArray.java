/*
 * FloatObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeFloatObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Float.
 * <p>
 * A Float Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jfloat</code> pointer array 
 * because Float objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeFloatObjectArray extends NativeNumberObjectArray
{
    /**
     * Returns the Float element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Float)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Float element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Float getFloat(int index);
    
    /**
     * Sets the Float element at the specified index synchronizing
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
    public void setFloat(int index,Float value);
    
    /**
     * Returns the internal Float array synchronized 
     * with the native memory if instance is native.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Float[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Float array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Float[] getFloatArray();
    
    /**
     * Sets the internal Float array synchronizing
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
    public void setFloatArray(Float[] value);   
}
