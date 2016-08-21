/*
 * NativeBooleanArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeBooleanArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of boolean.
 * <p>
 * A boolean Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a boolean array 
 * (<code>jboolean</code> elements).
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeBooleanArray extends NativePrimitiveArray
{
    /**
     * Returns the boolean element at the specified index synchronized 
     * with the native memory if instance is native using the specified
     * fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param index the zero-based index of the element.
     * @param fetchMode the fetch mode.
     * @return the boolean element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public boolean getBoolean(int index,int fetchMode);    
    
    /**
     * Sets the boolean element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     */     
    public void setBoolean(int index,boolean value,int unFetchMode);    
    
    /**
     * Returns the boolean element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation calls {@link #getBoolean(int,int)} using the
     * default fetch mode.
     *
     * @param index the zero-based index of the element.
     * @return the boolean element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public boolean getBoolean(int index);
    
    /**
     * Sets the boolean element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation calls {@link #setBoolean(int,boolean,int)} using the
     * default "unfetch" mode.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */      
    public void setBoolean(int index,boolean value);
    
    /**
     * Returns the internal boolean array synchronized 
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
     * return (boolean[])getValue();
     * </code></blockquote>
     *
     * @return the internal boolean array.
     * @see NativeSingleFieldContainer#getValue()
     */
    public boolean[] getBooleanArray();
    
    /**
     * Sets the internal boolean array synchronizing
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
    public void setBooleanArray(boolean[] value);
}
