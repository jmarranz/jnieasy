/*
 * NativeAddress.java
 *
 * Created on 26 de febrero de 2004, 11:55
 */

package com.innowhere.jnieasy.core.mem;

/**
 * The interface <code>NativeAddress</code> is implemented by the framework
 * to encapsulate a native address.
 * <p>
 * This address may depend on a parent address using an offset to 
 * indicate the relative position. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeManager#newAddress(long)
 * @see NativeManager#newAddress(NativeAddress,long)
 */
public interface NativeAddress
{
    /**
     * Returns the final stored address value contained.
     * <p>
     * If this address depends on a parent address, final address
     * is calculated as:
     * <blockquote><code>
     * getParentAddress() + getOffset()
     * </code></blockquote>
     *
     * @return the final stored address.
     */
    public long getValue();
    
    /**
     * Returns the parent address if defined.
     *
     * @return the parent address or null if does not exist.
     */    
    public NativeAddress getParentAddress();
    
    
    /**
     * Returns the relative offset of the parent address.
     *
     * @return the offset value, if does not exist a parent address returns -1 (not valid value).
     */       
    public long getOffset();    
}
