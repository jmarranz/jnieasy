/*
 * TypeNativeLong.java
 *
 * Created on 6 de marzo de 2006, 17:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeLong</code> is the interface that represents a native
 * type declaration using a long type.
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface TypeNativeLong extends TypeNativePrimitive
{
    /**
     * Returns true if the long type was declared as a pointer to a platform address
     * or if the native memory size is the same as the platform register size.
     * <p>
     * @return true if was declared as cross-platform.
     * @see NativeTypeManager#decAddress()
     * @see NativeTypeManager#decPrimitive(Class,long)
     */
    public boolean isAddress();    
}
