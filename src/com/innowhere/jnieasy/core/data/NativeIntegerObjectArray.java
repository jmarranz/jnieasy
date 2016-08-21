/*
 * IntegerObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeIntegerObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Integer.
 * <p>
 * An integer Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jint</code> pointer array 
 * because Integer objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeIntegerObjectArray extends NativeNumberObjectArray
{
    /**
     * Returns the Integer element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Integer)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Integer element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Integer getInteger(int index);
    
    /**
     * Sets the Integer element at the specified index synchronizing
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
    public void setInteger(int index,Integer value);   
    
    /**
     * Returns the internal Integer array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Integer[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Integer array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Integer[] getIntegerArray();
    
    /**
     * Sets the internal Integer array synchronizing
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
    public void setIntegerArray(Integer[] value);   
}
