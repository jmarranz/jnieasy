/*
 * NativeFieldMethodReflectionArray.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.data.NativeMemberReflectionArray;
import java.lang.reflect.*;

/**
 * The <code>NativeFieldMethodReflectionArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * one-dimensional java.lang.reflect.Field arrays.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeFieldMethodReflectionArray extends NativeMemberReflectionArray
{
    /**
     * Returns the Field element at the specified index synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Field)getObject(index);
     * </code></blockquote>
     *
     * @param index the zero-based index of the element.
     * @return the Field element at the specified index.
     * @see com.innowhere.jnieasy.core.data.NativeArray#getElement(int)
     */    
    public Field getField(int index);
    
    /**
     * Sets the Field element at the specified index synchronizing
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
    public void setField(int index,Field value);    
    
    /**
     * Returns the internal Field array synchronized 
     * with the native memory if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Field[])getObjectArray();
     * </code></blockquote>
     *
     * @return the internal Field array.
     * @see com.innowhere.jnieasy.core.data.NativeObjectArray#getObjectArray()
     */     
    public Field[] getFieldArray();
    
    /**
     * Sets the internal Field array synchronizing
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
    public void setFieldArray(Field[] value);
}

