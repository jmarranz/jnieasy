/*
 * NativeStringArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeStringArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.String arrays (String[]).
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
public interface NativeStringArray extends CanBeNativeCapableArray
{
    /**
     * Returns the String element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (String)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the String element at the specified index.
     * @see NativeArray#getElement(int)
     */            
    public String getString(int index);
    
    /**
     * Sets the String element at the specified index synchronizing
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
    public void setString(int index,String value);
    
    /**
     * Returns the internal String array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (String[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal String array.
     * @see NativeObjectArray#getObjectArray()
     */     
    public String[] getStringArray();
    
    /**
     * Sets the internal String array synchronizing
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
    public void setStringArray(String[] value);
}
