/*
 * NativeStringBufferArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeStringBufferArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.StringBuffer arrays (StringBuffer[]).
 * <p>
 * The corresponding native memory is an array of string pointers,
 * <code>char*[]</code> if ANSI, <code>wchar_t*[]</code> if UNICODE.
 * <p>
 * The framework defines an internal native class supporting ANSI and
 * UNICODE encodings/sizes.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStringBufferArray extends CanBeNativeCapableArray
{
    /**
     * Returns the StringBuffer element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (StringBuffer)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the StringBuffer element at the specified index.
     * @see NativeArray#getElement(int)
     */    
    public StringBuffer getStringBuffer(int index);
    
    /**
     * Sets the StringBuffer element at the specified index synchronizing
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
    public void setStringBuffer(int index,StringBuffer value);
    
    /**
     * Returns the internal StringBuffer array synchronized 
     * with the native memory if instance is native.
     * <p>
     * If instance is native, internal array is null and expected array length 
     * is undefined an exception is thrown.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (StringBuffer[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal StringBuffer array.
     * @see NativeObjectArray#getObjectArray()
     */    
    public StringBuffer[] getStringBufferArray();
    
    /**
     * Sets the internal StringBuffer array synchronizing
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
    public void setStringBufferArray(StringBuffer[] value);
}
