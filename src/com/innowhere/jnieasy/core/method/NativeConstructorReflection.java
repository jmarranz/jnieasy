/*
 * ConstructorReflectionWrapper.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import java.lang.reflect.Constructor;

/**
 * The <code>NativeConstructorReflection</code> is the interface implemented by
 * native capable classes that make accessible Java constructors
 * from native. The Java constructors are called using Java reflection.
 * <p>
 * The framework has an internal class implementing this interface.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeConstructorSignature#newConstructorReflection()
 */
public interface NativeConstructorReflection extends NativeBehaviorReflection, NativeConstructorCallback
{
    /**
     * Returns the internal java.lang.reflect.Constructor. Native memory is 
     * in no way read.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Constructor)getValue();
     * </code></blockquote>
     *
     * @return the internal reflection object.
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#getValue()
     */      
    public Constructor getConstructor();
    
    /**
     * Sets the internal java.lang.reflect.Constructor object. Native memory is 
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
    public void setConstructor(Constructor value);    
}

