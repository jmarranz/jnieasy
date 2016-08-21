/*
 * NativeLong.java
 *
 * Created on 25 de febrero de 2004, 19:34
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeLong</code> is the interface implemented by 
 * native capable classes wrapping a long value.
 * <p>
 * The framework has an internal class implementing this interface.
 * <p>
 * If native the corresponding native memory is a long (<code>jlong</code>),
 * a Java reference of this type can be considered like a <code>jlong*</code>
 * native variable.
 * <p>
 * This interface is used when using the expression "long*" with the method
 * {@link com.innowhere.jnieasy.core.typedec.NativeVarTypeManager#dec(String)}.
 * <p>
 * This type can be declared as cross-platform using 
 * the method {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#decAddress()} 
 * and {@link com.innowhere.jnieasy.core.typedec.TypeNativePrimitive#decObjectWrapper(Class)} with NativeLong.class parameter,
 * or with the expression "long{address}*" or "NativeLong{address}" or with the "address" attribute
 * in XML declarations. In this case the corresponding native memory 
 * is an int (<code>jint</code>) if the platform size is 32 bits, 
 * and a long (<code>jlong</code>) on 64 bit platforms.
 * Conversions between long (the external used type) and int are made with
 * normal casts. A Java reference of this type can be considered like a <code>jint*</code> on
 * 32 bit platforms or <code>jlong*</code> on 64 bit platforms.
 * <p>
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeLong extends NativeNumber
{
    /**
     * Returns the internal long value synchronized 
     * with the native memory if instance is native using the 
     * specified fetch mode.
     * <p>
     * Fetch values FAST, EMBEDDED and DEEP have the same behavior:
     * native memory is read and internal value is synchronized
     * before return.
     *
     * @param fetchMode the fetch mode.
     * @return the internal long value.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public long getLongValue(int fetchMode);
    
    /**
     * Sets the internal long value synchronizing
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
    public void setLongValue(long value,int unFetchMode);
    
    /**
     * Returns the internal long value synchronized 
     * with the native memory if instance is native using the 
     * default fetch mode.
     * <p>
     * Current implementation calls {@link #getLongValue(int)}
     * using the default fetch mode.
     *
     * @return the internal long value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */      
    public long getLongValue();
    
    /**
     * Sets the internal long value synchronizing
     * the native memory with the new value if instance is native 
     * using the default "unfetch" mode.
     * <p>
     * Current implementation calls {@link #setLongValue(long,int)}
     * using the default "unfetch" mode.
     *
     * @param value the new value.     
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */    
    public void setLongValue(long value);
}
