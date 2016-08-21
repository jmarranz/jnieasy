/*
 * NativeObjectArray.java
 *
 * Created on 17 de noviembre de 2004, 20:42
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeObjectArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * object arrays (String[], MyStructure[], int[][] etc).
 * <p>
 * The contained objects may be "can be native" (String, Integer,int[] ...)
 * or native capable objects (MyStructure, Pointer etc).
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeObjectArray extends NativeArray
{
   
    /**
     * Returns the internal Object array synchronized 
     * with the native memory if instance is native.
     * <p>
     * If instance is native, internal array is null and expected array length 
     * is undefined an exception is thrown.
     * 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Object[])getValue();
     * </code></blockquote>
     *
     * @return the internal Object array.
     * @see NativeSingleFieldContainer#getValue()
     */    
    public Object[] getObjectArray();
    
    /**
     * Sets the internal Object array synchronizing
     * the native memory with the new value if instance is native.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new array value.
     * @see NativeSingleFieldContainer#setValue(Object)
     */        
    public void setObjectArray(Object[] value);     
  
}
