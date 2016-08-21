/*
 * NativeFloatArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeFloatArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of float.
 * <p>
 * A float Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a float array 
 * (<code>jfloat</code> elements).
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeFloatArray extends NativeNumberArray
{
    /**
     * Returns the float element at the specified index synchronized 
     * with the native memory if instance is native using the specified
     * fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param index the zero-based index of the element.
     * @param fetchMode the fetch mode.
     * @return the float element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public float getFloat(int index,int fetchMode);    
    
    /**
     * Sets the float element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     */     
    public void setFloat(int index,float value,int unFetchMode);    
    
    /**
     * Returns the float element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation calls {@link #getFloat(int,int)} using the
     * default fetch mode.
     *
     * @param index the zero-based index of the element.
     * @return the float element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public float getFloat(int index);
    
    /**
     * Sets the float element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation calls {@link #setFloat(int,float,int)} using the
     * default "unfetch" mode.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */      
    public void setFloat(int index,float value);
    
    /**
     * Returns the internal float array synchronized 
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
     * return (float[])getValue();
     * </code></blockquote>
     *
     * @return the internal float array.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public float[] getFloatArray();
    
    /**
     * Sets the internal float array synchronizing
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
    public void setFloatArray(float[] value);
}
