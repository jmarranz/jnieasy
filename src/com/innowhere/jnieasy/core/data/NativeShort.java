/*
 * NativeShort.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeShort</code> is the interface implemented by 
 * native capable classes wrapping a short value.
 * <p>
 * The framework has an internal class implementing this interface.
 * <p>
 * If native the corresponding native memory is a short (<code>jshort</code>),
 * a Java reference of this type can be considered like a <code>jshort*</code>
 * native variable.
 * <p>
 * This interface is used when using the expression "short*" with the method
 * {@link com.innowhere.jnieasy.core.typedec.NativeVarTypeManager#dec(String)}. 
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeShort extends NativeNumber
{
    /**
     * Returns the internal short value synchronized 
     * with the native memory if instance is native using the 
     * specified fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param fetchMode the fetch mode.
     * @return the internal short value.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */
    public short getShortValue(int fetchMode);
    
    /**
     * Sets the internal short value synchronizing
     * the native memory with the new value if instance is native 
     * using the specified "unfetch" mode.
     * <p>
     * Unfetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is updated with the new value.
     *
     * @param value the new value.     
     * @param unFetchMode the "unfetch" mode.
     * @see NativeSingleFieldContainer#setValue(Object)
     */       
    public void setShortValue(short value,int unFetchMode);    
    
    /**
     * Returns the internal short value synchronized 
     * with the native memory if instance is native using the 
     * default fetch mode.
     * <p>
     * Current implementation calls {@link #getShortValue(int)}
     * using the default fetch mode.
     *
     * @return the internal short value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */        
    public short getShortValue();
    
    /**
     * Sets the internal short value synchronizing
     * the native memory with the new value if instance is native 
     * using the default "unfetch" mode.
     * <p>
     * Current implementation calls {@link #setShortValue(short,int)}
     * using the default "unfetch" mode.
     *
     * @param value the new value.     
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */    
    public void setShortValue(short value);
}
