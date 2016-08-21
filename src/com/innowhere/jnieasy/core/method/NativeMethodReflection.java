/*
 * NativeMethodReflection.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import java.lang.reflect.*;

/**
 * The <code>NativeMethodReflection</code> is the interface implemented by
 * native capable classes that make accessible Java methods
 * from native. Java methods 
 * are accessed using Java reflection.
 * <p>
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeMethodSignature#newMethodReflection(Method)
 */
public interface NativeMethodReflection extends NativeBehaviorReflection, NativeMethodCallback
{
    /**
     * Returns the internal java.lang.reflect.Method. Native memory is 
     * in no way read.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Method)getValue();
     * </code></blockquote>
     *
     * @return the internal reflection object.
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#getValue()
     */     
    public Method getMethod();
    
    /**
     * Sets the internal java.lang.reflect.Method object. Native memory is 
     * in no way updated.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#setValue(Object)
     */         
    public void setMethod(Method value);    
}

