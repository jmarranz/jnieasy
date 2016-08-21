/*
 * NativeBehaviorReflectionArray.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.data.NativeMemberReflectionArray;

/**
 * The <code>NativeBehaviorReflectionArray</code> is the interface implemented by 
 * native capable classes working as wrappers of
 * one-dimensional reflection object arrays (Field[], Method[], Constructor[]).
 * Array elements are seen as methods from the native side.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeBehaviorReflectionArray extends NativeMemberReflectionArray
{
}

