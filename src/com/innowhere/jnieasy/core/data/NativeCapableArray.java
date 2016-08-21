/*
 * NativeCapableArray.java
 *
 * Created on 25 de febrero de 2004, 21:38
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeCapableArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * native capable object arrays (MyStructure[], Pointer[] etc).
 * <p>
 * The contained objects must be objects of native capable classes 
 * (MySructure, Pointer etc).
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeCapableArray extends NativeObjectArray
{
    
}
