/*
 * NativeCharacterArray.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeCharacterArray</code> is the interface implemented by 
 * native capable classes wrapping one-dimensional native arrays of character.
 * <p>
 * A character Java array is wrapped with a predefined internal 
 * class implementing this interface.
 * <p>
 * If native the corresponding native memory is a character array 
 * (<code>jchar</code> elements).
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeCharacterArray extends NativePrimitiveArray
{
    /**
     * Returns the character element at the specified index synchronized 
     * with the native memory if instance is native using the specified
     * fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param index the zero-based index of the element.
     * @param fetchMode the fetch mode.
     * @return the character element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public char getChar(int index,int fetchMode);    
    
    /**
     * Sets the character element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     */     
    public void setChar(int index,char value,int unFetchMode);    
    
    /**
     * Returns the character element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation calls {@link #getChar(int,int)} using the
     * default fetch mode.
     *
     * @param index the zero-based index of the element.
     * @return the character element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public char getChar(int index);
    
    /**
     * Sets the character element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation calls {@link #setChar(int,char,int)} using the
     * default "unfetch" mode.
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */      
    public void setChar(int index,char value);
    
    /**
     * Returns the internal character array synchronized 
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
     * return (char[])getValue();
     * </code></blockquote>
     *
     * @return the internal character array.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public char[] getCharArray();

    /**
     * Sets the internal character array synchronizing
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
    public void setCharArray(char[] value);
}
