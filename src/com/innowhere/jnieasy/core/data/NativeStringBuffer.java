/*
 * StringWrapper.java
 *
 * Created on 26 de febrero de 2004, 14:16
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeStringBuffer</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * java.lang.StringBuffer objects.
 * <p>
 * The framework defines an internal native class supporting ANSI and
 * UNICODE encodings/sizes.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeStringBuffer extends NativeStringBased
{
    /**
     * Returns the internal StringBuffer object synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (StringBuffer)getValue();
     * </code></blockquote>
     *
     * @return the internal StringBuffer object. Never is null.
     * @see NativeSingleFieldContainer#getValue()
     */        
    public StringBuffer getStringBuffer();
    
    /**
     * Sets the internal StringBuffer object synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */          
    public void setStringBuffer(StringBuffer value);
    
    /**
     * Returns the character at the specified index synchronized 
     * with the native memory if instance is native using the specified
     * fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param index the zero-based index of the character.
     * @param fetchMode the fetch mode.
     * @return the character at the specified index.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public char getCharacter(int index,int fetchMode);    
    
    /**
     * Sets the character at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param index the zero-based index of the character.
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     */     
    public void setCharacter(int index,char value,int unFetchMode);     
    
    /**
     * Returns the character element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation calls {@link #getCharacter(int,int)} using the
     * default fetch mode.
     *
     * @param index the zero-based index of the character.
     * @return the character at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public char getCharacter(int index);    
    
    /**
     * Sets the character at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation calls {@link #setCharacter(int,char,int)} using the
     * default "unfetch" mode.
     *
     * @param index the zero-based index of the character.
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */    
    public void setCharacter(int index,char value);
}
