/*
 * AddressedArray.java
 *
 * Created on 1 de abril de 2004, 14:50
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * arrays (String[], MyStructure[], int[], int[][] etc).
 * <p>
 * The contained elements may be objects ("can be native" and native
 * capable) or primitive values (int, long etc).
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeArray extends CanBeNativeCapable
{
    /**
     * Returns the element at the specified index. If instance is native
     * the returned object is synchronized with the native memory 
     * fetching data with the specified deepness.
     * <p>
     * If is not native it works as a normal array.
     * <p>
     * If a primitive array the element is wrapped.
     *
     * @param index the zero-based index of the element.
     * @param fetchMode the fetch method to copy from native memory.
     * @return the object element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#fetch(Object,int)
     */ 
    public Object getElement(int index,int fetchMode);
    
    /**
     * Sets the element at the specified index with the new value. 
     * If instance is native the native memory is updated 
     * unfetching data with the specified deepness.
     * <p>
     * If is not native it works as a normal array.
     * <p>
     * If a primitive array the element must be a wrapper.
     *
     * @param index the zero-based index of the element.
     * @param value the new value at the specified position.
     * @param unFetchMode the "unfetch" method to copy from native memory.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#unFetch(Object,int)
     */     
    public void setElement(int index,Object value,int unFetchMode);    
    
    
    /**
     * Returns the element at the specified index. If instance is native
     * the returned object is synchronized with the native memory 
     * fetching data with the default fetching mode.
     * <p>      
     * Current implementation calls {@link #getElement(int,int)} using
     * the default fetching mode.
     * 
     * 
     * @param index the zero-based index of the element.
     * @return the object element at the specified index.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */
    public Object getElement(int index);  
    
    /**
     * Sets the element at the specified index with the new value. 
     * If instance is native the native memory is updated 
     * unfetching data with the default deepness.
     * <p>      
     * Current implementation calls {@link #setElement(int,Object,int)} using
     * the default "unfetching" mode.
     * 
     * @param index the zero-based index of the element.
     * @param value the new value at the specified position.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */
    public void setElement(int index,Object value); 
    
    /**
     * Returns the element at the specified list of indexes. If instance is native
     * the returned object is synchronized with the native memory 
     * fetching data with the default fetching mode.
     * <p>      
     * Current implementation calls {@link #getElement(int[],int,int)} using
     * the default fetching mode and <code>dimStart</code> = 0.
     * 
     * @param dims the index list of the element.
     * @return the object element at the specified indexes.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public Object getElement(int[] dims);     
    
    
    /**
     * Returns the element at the specified list of indexes. If instance is native
     * the returned object is synchronized with the native memory 
     * fetching data with the specified deepness.
     * <p>
     * If is not native it works as a normal array.
     * <p>
     * If a primitive array the element is wrapped.
     *
     * @param dims the index list of the element.
     * @param dimStart the starting dimension of <code>dims</code>.
     * @param fetchMode the fetch method to copy from native memory.
     * @return the object element at the specified indexes.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#fetch(Object,int)
     */     
    public Object getElement(int[] dims,int dimStart,int fetchMode);    
    
    /**
     * Sets the element at the specified list of indexes with the new value. 
     * If instance is native the native memory is updated 
     * unfetching data with the default deepness.
     * <p>      
     * Current implementation calls {@link #setElement(int[],int,Object,int)} using
     * the default "unfetching" mode and <code>dimStart</code> = 0.
     * 
     * @param dims the index list of the element.
     * @param value the new value at the specified position.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */    
    public void setElement(int[] dims,Object value);     
    
    /**
     * Sets the element at the specified list of indexes with the new value. 
     * If instance is native the native memory is updated 
     * unfetching data with the specified deepness.
     * <p>
     * If is not native it works as a normal array.
     * <p>
     * If a primitive array the element must be a wrapper.
     *
     * @param dims the index list of the element.
     * @param dimStart the starting dimension of <code>dims</code>.
     * @param value the new value at the specified position.
     * @param unFetchMode the "unfetch" method to copy from native memory.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#unFetch(Object,int)
     */    
    public void setElement(int[] dims,int dimStart,Object value,int unFetchMode);    

    /**
     * Returns the length of the internal array field.
     *
     * @return the length of the array.
     */       
    public int length();
    
}
