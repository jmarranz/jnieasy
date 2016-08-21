/*
 * NativeStaticMethodCallback.java
 *
 * Created on 12 de febrero de 2004, 19:46
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectStaticMethodCallback</code> is the interface implemented by
 * native capable classes that make accessible static Java methods
 * from native. The Java methods are NOT called using Java reflection.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeStaticMethodSignature#newDirectStaticMethodCallback(Class,String)
 */
public interface NativeDirectStaticMethodCallback extends NativeDirectMethodCallback,NativeStaticMethodCallback
{
}
