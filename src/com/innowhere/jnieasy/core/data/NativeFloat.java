/*
 * NativeFloat.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeFloat</code> is the interface implemented by 
 * native capable classes wrapping a float value.
 * <p>
 * The framework has an internal class implementing this interface.
 * <p>
 * If native the corresponding native memory is a float (<code>jfloat</code>),
 * a Java reference of this type can be considered like a <code>jfloat*</code>
 * native variable.
 * <p>
 * This interface is used when using the expression "float*" with the method
 * {@link com.innowhere.jnieasy.core.typedec.NativeVarTypeManager#dec(String)}. 
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeFloat extends NativeNumber
{
    /**
     * Returns the internal float value synchronized 
     * with the native memory if instance is native using the 
     * specified fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param fetchMode the fetch mode.
     * @return the internal float value.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public float getFloatValue(int fetchMode);
    
    /**
     * Sets the internal float value synchronizing
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
    public void setFloatValue(float value,int unFetchMode);
    
    /**
     * Returns the internal float value synchronized 
     * with the native memory if instance is native using the 
     * default fetch mode.
     * <p>
     * Current implementation calls {@link #getFloatValue(int)}
     * using the default fetch mode.
     *
     * @return the internal float value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */        
    public float getFloatValue();
    
    /**
     * Sets the internal float value synchronizing
     * the native memory with the new value if instance is native 
     * using the default "unfetch" mode.
     * <p>
     * Current implementation calls {@link #setFloatValue(float,int)}
     * using the default "unfetch" mode.
     *
     * @param value the new value.     
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */    
    public void setFloatValue(float value);
}
