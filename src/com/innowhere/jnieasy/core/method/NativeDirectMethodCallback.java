/*
 * NativeDirectMethodCallback.java
 *
 * Created on 1 de abril de 2005, 12:48
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectMethodCallback</code> is the interface implemented by
 * native capable classes that make accessible Java methods
 * from native. Java methods are NOT accessed using Java reflection.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeMethodSignature#newDirectMethodCallback(Method)
 */
public interface NativeDirectMethodCallback extends NativeDirectCallback,NativeMethodCallback
{
    
}
