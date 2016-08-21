/*
 * NativeMethod.java
 *
 * Created on 1 de abril de 2005, 13:40
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;

/**
 * The <code>NativeMethod</code> is the interface implemented by
 * native capable classes that bridges Java and native methods. 
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeMethod extends NativeBehavior
{
    /**
     * Returns the native signature of the method instance.
     *
     * @return the native signature object.
     */      
    public NativeMethodSignature getMethodSignature();
}
