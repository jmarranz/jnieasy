/*
 * ByteObjectWrapper.java
 *
 * Created on 9 de diciembre de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeByteObjectArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of java.lang.Byte.
 * <p>
 * A Byte Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a <code>jbyte</code> pointer array 
 * because Byte objects are ever referenced "by pointer".
 * A Java reference of this type can be considered like a pointer
 * to the first pointer of the array.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeByteObjectArray extends NativeNumberObjectArray
{
    /**
     * Returns the Byte element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Byte)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Byte element at the specified index.
     * @see NativeArray#getElement(int)
     */        
    public Byte getByte(int index);
    
    /**
     * Sets the Byte element at the specified index synchronizing
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
    public void setByte(int index,Byte value);   
    
    /**
     * Returns the internal Byte array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Byte[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Byte array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public Byte[] getByteArray();
    
    /**
     * Sets the internal Byte array synchronizing
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
    public void setByteArray(Byte[] value);   
}
