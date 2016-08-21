/*
 * TypeNativeString.java
 *
 * Created on 10 de enero de 2005, 21:58
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.data.NativeString;

/**
 * The <code>TypeNativeString</code> is the interface that 
 * represents a native type declaration of java.lang.String
 * and related wrapper classes.  
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeString
 */
public interface TypeNativeString extends TypeNativeStringBased
{
    /**
     * Wraps (makes native capable) a String object with a NativeString 
     * wrapper object.
     *
     * @param value the String value to wrap.
     * @return the native wrapper object.
     * @see TypeCanBeNativeCapable#wrapValue(Object)
     */    
    public NativeString newString(String value);
}
