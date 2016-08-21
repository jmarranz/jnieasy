/*
 * NativeArrayOfArray.java
 *
 * Created on 27 de diciembre de 2004, 13:21
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeArrayOfArray</code> is the interface implemented by
 * native capable classes wrapping multidimensional native arrays.
 * <p>
 * A multidimensional Java array is wrapped with a predefined internal 
 * class implementing this interface, unless a user defined multidimensional
 * array is used. User defined multidimensional arrays implements 
 * this interface too.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeArrayOfArray extends CanBeNativeCapableArray
{
    
}
