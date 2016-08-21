/*
 * NativeConstructorCallback.java
 *
 * Created on 13 de febrero de 2004, 14:22
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectConstructorCallback</code> is the interface implemented by
 * native capable classes that make accessible Java constructors
 * from native. The Java constructors are NOT called using Java reflection.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeConstructorSignature#newDirectConstructorCallback()
 */
public interface NativeDirectConstructorCallback extends NativeDirectCallback, NativeConstructorCallback
{

}
