/*
 * BooleanObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeBooleanObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Boolean.
 * <p>
 * A Boolean Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jboolean</code> pointer array 
 * because Boolean objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeBooleanObjectArray extends NativePrimitiveObjectArray
{
    /**
     * Returns the Boolean element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Boolean)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Boolean element at the specified index.
     * @see NativeArray#getElement(int)
     */    
    public Boolean getBoolean(int index);
    
    /**
     * Sets the Boolean element at the specified index synchronizing
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
    public void setBoolean(int index,Boolean value);
    
    /**
     * Returns the internal Boolean array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Boolean[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Boolean array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Boolean[] getBooleanArray();
    
    /**
     * Sets the internal Boolean array synchronizing
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
    public void setBooleanArray(Boolean[] value);   
}
