/*
 * ConstructorReflectionWrapper.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import java.lang.reflect.*;

/**
 * The <code>NativeConstructorReflectionArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * one-dimensional java.lang.reflect.Constructor arrays.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeConstructorReflectionArray extends NativeBehaviorReflectionArray
{
    /**
     * Returns the Constructor element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Constructor)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Constructor element at the specified index.
     * @see com.innowhere.jnieasy.core.data.NativeArray#getElement(int)
     */        
    public Constructor getConstructor(int index);
    
    /**
     * Sets the Constructor element at the specified index synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setObject(index,value);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @param value the new value.
     */    
    public void setConstructor(int index,Constructor value); 
    
    /**
     * Returns the internal Constructor array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Constructor[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Constructor array.
     * @see com.innowhere.jnieasy.core.data.NativeObjectArray#getObjectArray()
     */         
    public Constructor[] getConstructorArray();
    
    /**
     * Sets the internal Constructor array synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setObjectArray(value);
     * </code></blockquote>
     *
     * @param value the new array value.
     * @see com.innowhere.jnieasy.core.data.NativeObjectArray#setObjectArray(Object[])
     */     
    public void setConstructorArray(Constructor[] value);
}

