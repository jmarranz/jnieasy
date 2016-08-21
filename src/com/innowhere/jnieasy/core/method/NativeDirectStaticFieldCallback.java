/*
 * StaticMethodCallback.java
 *
 * Created on 12 de febrero de 2004, 19:46
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectStaticFieldCallback</code> is the interface implemented by
 * native capable classes that make accessible static Java fields
 * from native as methods. The Java fields are NOT accessed using Java reflection.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature#newDirectStaticFieldCallback(Class,String)
 */
public interface NativeDirectStaticFieldCallback extends NativeDirectFieldCallback,NativeStaticFieldCallback
{
   
}
