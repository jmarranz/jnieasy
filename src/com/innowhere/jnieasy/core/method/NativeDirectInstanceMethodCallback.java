/*
 * NativeInstanceMethodCallback.java
 *
 * Created on 12 de febrero de 2004, 20:10
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectInstanceMethodCallback</code> is the interface implemented by
 * native capable classes that make accessible Java instance methods
 * from native. The Java methods are NOT called using Java reflection.
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeInstanceMethodSignature#newDirectInstanceMethodCallback(String)
 */
public interface NativeDirectInstanceMethodCallback extends NativeDirectMethodCallback, NativeInstanceMethodCallback
{
}
