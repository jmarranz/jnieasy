/*
 * BasicDataWrapper.java
 *
 * Created on 13 de noviembre de 2004, 10:06
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>CanBeNativeCapable</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * "can be native" objects (String, Integer, Java arrays etc).
 * <p>
 * An instance contains (or must contain) a "can be native" object, 
 * it serves as a bridge between the 
 * native world and Java world: native world can read/modify the native memory
 * related to this native instance, if a Java program gets the contained
 * object, it is synchronized with native memory, again if the Java program
 * modifies the contained object the native memory is modified according to.
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSingleFieldContainer#getValue()
 * @see NativeSingleFieldContainer#setValue(Object)
 */
public interface CanBeNativeCapable extends NativeObjectFieldContainer
{
    
}
