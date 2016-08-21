/*
 * NativeLongArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeLongArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of long.
 * <p>
 * A long Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a long array 
 * (<code>jlong</code> elements).
 * <p>
 * This type can be declared as cross-platform using 
 * the method {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#decAddress()} 
 * to declare the long component as cross-platform and use this declaration 
 * to declare the array, the expression "long{address}[]" may used too and in XML
 * the "address" attribute must be used as modifier of the (long) component declaration.
 * In this case the corresponding native memory 
 * is an int[length] (<code>jint[length]</code>) if the platform size is 32 bits, 
 * and a long[length] (<code>jlong[length]</code>) on 64 bit platforms.
 * Conversions between long (the external used type) and int are made with
 * normal casts.
 * <p>
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeLongArray extends NativeNumberArray
{
    /**
     * Returns the long element at the specified index synchronized 
     * with the native memory if instance is native using the specified
     * fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param index the zero-based index of the element.
     * @param fetchMode the fetch mode.
     * @return the long element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public long getLong(int index,int fetchMode);    
    
    /**
     * Sets the long element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     */     
    public void setLong(int index,long value,int unFetchMode);    
    
    /**
     * Returns the long element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation calls {@link #getLong(int,int)} using the
     * default fetch mode.
     *
     * @param index the zero-based index of the element.
     * @return the long element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public long getLong(int index);
    
    /**
     * Sets the long element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation calls {@link #setLong(int,long,int)} using the
     * default "unfetch" mode.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */      
    public void setLong(int index,long value);
    
    /**
     * Returns the internal long array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Array synchronization with native memory is made 
     * copying the complete memory block one time, avoiding 
     * a performance penalty with big arrays.
     * <p>
     * If instance is native, internal array is null and expected array length 
     * is undefined an exception is thrown.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (long[])getValue();
     * </code></blockquote>
     *
     * @return the internal long array.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public long[] getLongArray();
    
    /**
     * Sets the internal long array synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Array synchronization with native memory is made 
     * copying the complete memory block one time, avoiding 
     * a performance penalty with big arrays.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new array value.
     * @see NativeSingleFieldContainer#setValue(Object)
     */    
    public void setLongArray(long[] value);
}
