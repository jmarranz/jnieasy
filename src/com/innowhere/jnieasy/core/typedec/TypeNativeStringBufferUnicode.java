/*
 * TypeNativeStringBufferUnicode.java
 *
 * Created on 22 de mayo de 2005, 12:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.data.NativeStringBufferUnicode;

/**
 * The <code>TypeNativeStringBufferUnicode</code> is the interface that 
 * represents a native type declaration of NativeStringBufferUnicode.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeStringBufferUnicode
 */
public interface TypeNativeStringBufferUnicode extends TypeNativeStringBuffer
{
    /**
     * Wraps (makes native capable) a StringBuffer object with a NativeStringBufferUnicode 
     * wrapper object.
     * 
     * 
     * @param value the NativeStringBufferUnicode value to wrap.
     * @return the native capable wrapper object.
     * @see TypeCanBeNativeCapable#wrapValue(Object)
     */      
    public NativeStringBufferUnicode newStringBufferUnicode(StringBuffer value);
}
