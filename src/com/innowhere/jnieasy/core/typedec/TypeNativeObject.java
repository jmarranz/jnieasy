/*
 * TypeNativeObject.java
 *
 * Created on 13 de mayo de 2005, 12:14
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeObject</code> is the interface that 
 * represents a native type declaration of Object based classes:
 * "can be native" and native capable classes (predefined and user 
 * defined).  
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativeCapable
 */
public interface TypeNativeObject extends TypeNative
{
    /**
     * Returns a new instance of the class used to declare the
     * native type.
     * <p>    
     * For instance: if java.lang.String was used to declare this 
     * native type, the returned object is a empty java.lang.String.
     * <p>     
     * The object is created with a normal <code>new</code>, without reflection 
     * (except the first instance used as factory and multidimensional 
     * arrays).
     * <p>
     * It native type was declared using a native class, the returned
     * object is native capable but is not made native, to make native 
     * use {@link com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object)}.
     * <p>
     * Returned wrapper objects of "can be native" objects are 
     * usually incompleted, set a value with 
     * {@link com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#setValue(Object)}
     * before make native.
     *
     * @return the new object.
     */
    public Object newValue();    
}
