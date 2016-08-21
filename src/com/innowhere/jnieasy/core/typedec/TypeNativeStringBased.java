/*
 * TypeNativeStringBased.java
 *
 * Created on 14 de enero de 2005, 13:49
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeStringBased</code> is the interface that 
 * represents a native type declaration of java.lang.String or 
 * java.lang.StringBuffer and related wrapper classes.  
 * <p>
 * Expression syntax if declaring the type using a string with
 * {@link NativeTypeManager#dec(String,String[])} :
 * <p> 
 * <blockquote><code>
 * <i>ClassName</i>[{ ANSI | UNICODE | ansi | unicode }]
 * </code></blockquote>  
 * <p>
 * <p>
 * Spaces may be used as separators when appropriated.
 * <p>
 * Examples:
 * <p>
 * <code>"String"</code><p>
 * <blockquote>Declares a string native type using String with 
 * default encoding, if default encoding is ANSI is equivalent to 
 * <code>char*</code> in C/C++</blockquote>
 * 
 * <code>"String{unicode}"</code><p>
 * <blockquote>Declares a string native type (<code>wchar_t*</code> in C/C++) using String with 
 * UNICODE encoding and <code>wchar_t</code> native C type.</blockquote>
 * 
 * <code>"String", "StringBuffer{ansi}", 
 * "com.innowhere.jnieasy.core.data.NativeString{unicode}"</code>
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeStringBased
 */
public interface TypeNativeStringBased extends TypeCanBeNativeCapable
{
    /**
     * Returns the string encoding/size of the characters defined in
     * the native type.
     *
     * @return the encoding/size value.
     * @see StringEncoding
     * @see NativeTypeManager#decString(Class,int)
     * @see NativeTypeManager#decStringBuffer(Class,int)     
     */      
    public int getEncoding();    
}
