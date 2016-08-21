/*
 * TypeNativeStringBuffer.java
 *
 * Created on 10 de enero de 2005, 21:58
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.data.NativeStringBuffer;

/**
 * The <code>TypeNativeStringBuffer</code> is the interface that 
 * represents a native type declaration of java.lang.StringBuffer
 * and related wrapper classes.  
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeStringBuffer
 */
public interface TypeNativeStringBuffer extends TypeNativeStringBased
{
    /**
     * Wraps (makes native capable) a StringBuffer object with a NativeStringBuffer 
     * wrapper object.
     *
     * @param value the StringBuffer value to wrap.
     * @return the native capable wrapper object.
     * @see TypeCanBeNativeCapable#wrapValue(Object)
     */        
    public NativeStringBuffer newStringBuffer(StringBuffer value);
}
