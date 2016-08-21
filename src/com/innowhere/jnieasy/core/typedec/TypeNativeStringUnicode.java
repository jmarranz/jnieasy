/*
 * TypeNativeStringUnicode.java
 *
 * Created on 22 de mayo de 2005, 12:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.data.NativeStringUnicode;

/**
 * The <code>TypeNativeStringUnicode</code> is the interface that 
 * represents a native type declaration of NativeStringUnicode.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeStringUnicode
 */
public interface TypeNativeStringUnicode extends TypeNativeString
{
    /**
     * Wraps (makes native capable) a String object with a NativeStringUnicode 
     * wrapper object.
     * 
     * 
     * @param value the String value to wrap.
     * @return the native capable wrapper object.
     * @see TypeCanBeNativeCapable#wrapValue(Object)
     */        
    public NativeStringUnicode newStringUnicode(String value);
}
