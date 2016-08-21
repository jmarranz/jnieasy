/*
 * NativeDoubleArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeDoubleArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of double.
 * <p>
 * A double Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a double array 
 * (<code>jdouble</code> elements).
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeDoubleArray extends NativeNumberArray
{
    /**
     * Returns the double element at the specified index synchronized 
     * with the native memory if instance is native using the specified
     * fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param index the zero-based index of the element.
     * @param fetchMode the fetch mode.
     * @return the double element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public double getDouble(int index,int fetchMode);    
    
    /**
     * Sets the double element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     */     
    public void setDouble(int index,double value,int unFetchMode);    
    
    /**
     * Returns the double element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation calls {@link #getDouble(int,int)} using the
     * default fetch mode.
     *
     * @param index the zero-based index of the element.
     * @return the double element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public double getDouble(int index);
    
    /**
     * Sets the double element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation calls {@link #setDouble(int,double,int)} using the
     * default "unfetch" mode.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */      
    public void setDouble(int index,double value);
    
    /**
     * Returns the internal double array synchronized 
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
     * return (double[])getValue();
     * </code></blockquote>
     *
     * @return the internal double array.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public double[] getDoubleArray();
    
    /**
     * Sets the internal double array synchronizing
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
    public void setDoubleArray(double[] value);
}
