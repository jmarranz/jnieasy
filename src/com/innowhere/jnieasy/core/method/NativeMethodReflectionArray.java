/*
 * NativeMethodReflectionArray.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import java.lang.reflect.*;
/**
 * The <code>NativeMethodReflectionArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * one-dimensional java.lang.reflect.Method arrays.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeMethodReflectionArray extends NativeBehaviorReflectionArray
{
    /**
     * Returns the Method element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Method)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Method element at the specified index.
     * @see com.innowhere.jnieasy.core.data.NativeArray#getElement(int)
     */     
    public Method getMethod(int index);   
    
    /**
     * Sets the Method element at the specified index synchronizing
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
    public void setMethod(int index,Method value);
    
    /**
     * Returns the internal Method array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Method[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Method array.
     * @see com.innowhere.jnieasy.core.data.NativeObjectArray#getObjectArray()
     */     
    public Method[] getMethodArray();
    
    /**
     * Sets the internal Method array synchronizing
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
    public void setMethodArray(Method[] value);
}

