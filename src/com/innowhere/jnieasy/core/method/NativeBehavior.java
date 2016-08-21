/*
 * NativeBehavior.java
 *
 * Created on 13 de febrero de 2004, 11:04
 */

package com.innowhere.jnieasy.core.method;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>NativeBehavior</code> is the interface implemented by
 * native capable classes that bridges Java and native methods and fields (as methods).
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeBehavior extends NativeCapable
{
    /**
     * Returns the native signature of the behavior instance.
     *
     * @return the native signature object.
     */    
    public NativeBehaviorSignature getBehaviorSignature();
}
