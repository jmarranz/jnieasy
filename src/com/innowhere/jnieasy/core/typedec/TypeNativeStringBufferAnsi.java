/*
 * TypeNativeStringBufferAnsi.java
 *
 * Created on 22 de mayo de 2005, 12:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.data.NativeStringBufferAnsi;

/**
 * The <code>TypeNativeStringBufferAnsi</code> is the interface that 
 * represents a native type declaration of NativeStringBufferAnsi.
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeStringBufferAnsi
 */
public interface TypeNativeStringBufferAnsi extends TypeNativeStringBuffer
{
    /**
     * Wraps (makes native capable) a StringBuffer object with a NativeStringBufferAnsi 
     * wrapper object.
     * 
     * 
     * @param value the NativeStringBufferAnsi value to wrap.
     * @return the native capable wrapper object.
     * @see TypeCanBeNativeCapable#wrapValue(Object)
     */     
    public NativeStringBufferAnsi newStringBufferAnsi(StringBuffer value);
}
