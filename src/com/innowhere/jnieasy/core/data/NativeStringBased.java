/*
 * NativeStringBased.java
 *
 * Created on 23 de mayo de 2005, 20:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeStringBased</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * string objects: String and StringBuffer.
 * <p>
 * Corresponding native memory of a native instance is a '\0' terminated native C string. 
 * The encoding/size rules if native C <code>char</code> o <code>wchar_t</code>
 * is used.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStringBased extends CanBeNativeCapable
{
    /**
     * Returns the string encoding/size of the characters defined in
     * the native type.
     *
     * @return the encoding/size value.
     * @see com.innowhere.jnieasy.core.typedec.TypeNativeStringBased#getEncoding()   
     */ 
    public int getEncoding();
}
