/*
 * StringEncoding.java
 *
 * Created on 5 de noviembre de 2004, 14:29
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>StringEncoding</code> declares the constants used to define
 * the encoding and size of characters of native strings.
 *
 * @author  Jose M. Arranz Santamaria
 * @see NativeTypeManager#getDefaultStringEncoding()
 * @see NativeTypeManager#decString(Class,int)
 * @see NativeTypeManager#decStringBuffer(Class,int)
 */

public interface StringEncoding
{
    /**
     * Constant used to define the coding size of 1 byte of the characters 
     * of native strings. On C/C++ is equivalent to use the 
     * <code>char</code> type.
     */
    public int ANSI = 1;
    
    /**
     * Constant used to define the coding size of 2 byte of the characters 
     * of native strings. On C/C++ is equivalent to use the 
     * <code>wchar_t</code> type.
     */    
    public int UNICODE = 2;  
}
