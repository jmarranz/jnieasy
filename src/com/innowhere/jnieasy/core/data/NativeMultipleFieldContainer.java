/*
 * NativeMultipleFieldContainer.java
 *
 * Created on 11 de diciembre de 2004, 12:33
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeMultipleFieldContainer</code> is the interface implemented by 
 * native capable classes containing multiple fields like unions, 
 * structures and C++ classes.
 * <p>
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeMultipleFieldContainer extends NativeFieldContainer
{
    /**
     * Returns the absolute number of native fields of this instance.
     *
     * @return the absolute numbers of fields.
     * @see com.innowhere.jnieasy.core.typedec.NativeMultipleFieldContainerDescriptor#getAbsoluteFieldCount()
     */
    public int jnieasyGetAbsoluteFieldCount();  
   
    /**
     * Returns the value of the native field with the specified index
     * and fetch mode.
     * <p>
     * If instance is native, the field value is synchronized with 
     * native memory before returned using the specified fetch mode.
     * <p>
     * If field is primitive the returned object is a primitive wrapper object.
     *
     * @param index the zero-based index of the field.
     * @param fetchMode the fetch mode to read native memory.
     * @return the value of the specified field.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public Object jnieasyGetField(int index,int fetchMode);
    
    /**
     * Sets a new the value to the native field with the specified index
     * and "unfetch" mode.
     * <p>
     * If instance is native, the native memory is updated (synchronized) 
     * with the new value using the specified "unfetch" mode.
     * <p>
     * If field is primitive the new value must be a primitive wrapper object.
     *
     * @param index the zero-based index of the field.
     * @param value the new value of the field.
     * @param unFetchMode the "unfetch" mode to write native memory.
     * @see com.innowhere.jnieasy.core.mem.UnFetch
     */      
    public void jnieasySetField(int index,Object value,int unFetchMode); 
    
    /**
     * Returns the value of the native field with the specified index
     * and default fetch mode.
     * <p>
     * Current implementation calls {@link #jnieasyGetField(int,int)}
     * with the default fetch mode.
     *
     * @param index the zero-based index of the field.
     * @return the value of the specified field.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */
    public Object jnieasyGetField(int index);
    
    /**
     * Sets a new the value to the native field with the specified index
     * and default "unfetch" mode.
     * <p>
     * Current implementation calls {@link #jnieasySetField(int,Object,int)}
     * with the default "unfetch" mode.
     *
     * @param index the zero-based index of the field.
     * @param value the new value of the field.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */
    public void jnieasySetField(int index,Object value);    
}
