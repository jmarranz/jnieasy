/*
 * TypeCanBeNativeCapable.java
 *
 * Created on 13 de mayo de 2005, 12:13
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.data.CanBeNativeCapable;

/**
 * The <code>TypeCanBeNativeCapable</code> is the interface that 
 * represents a native type declaration of "can be native" 
 * classes and native wrapper classes 
 * (user defined and predefined). 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see CanBeNativeCapable
 */
public interface TypeCanBeNativeCapable extends TypeNativeObject
{
    /**
     * Wraps (makes native capable) a "can be native" object with a 
     * native capable wrapper object.
     * <p>
     * For instance: 
     * <ul>
     *  <li>If <code>value</code> is a String instance, 
     *      the returned object is a 
     *      {@link com.innowhere.jnieasy.core.data.NativeString}. 
     *  <li>If <code>value</code> is a String[] instance, 
     *      the returned object is a 
     *      {@link com.innowhere.jnieasy.core.data.NativeStringArray}.
     *  <li>If <code>value</code> is an Integer instance, 
     *      the returned object is a 
     *      {@link com.innowhere.jnieasy.core.data.NativeIntegerObject}.
     * </ul>
     * If <code>value</code> is null, returns null.
     *
     * @param value the "can be native" object to wrap.
     * @return the native wrapper object or null.
     */
    public CanBeNativeCapable wrapValue(Object value);    
}
