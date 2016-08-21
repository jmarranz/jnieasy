/*
 * NativeFieldMethodReflection.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import java.lang.reflect.*;
/**
 * The <code>NativeFieldMethodReflection</code> is the interface implemented by
 * native capable classes that make accessible Java fields
 * from native seen as methods. Java fields 
 * are accessed using Java reflection.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature#newFieldMethodReflection(Field)
 */
public interface NativeFieldMethodReflection extends NativeBehaviorReflection,NativeFieldCallback
{
    /**
     * Returns the internal java.lang.reflect.Field. Native memory is 
     * in no way read.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Field)getValue();
     * </code></blockquote>
     *
     * @return the internal reflection object.
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#getValue()
     */ 
    public Field getField();
    
    /**
     * Sets the internal java.lang.reflect.Field object. Native memory is 
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
    public void setField(Field value);
}
