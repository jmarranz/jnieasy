/*
 * NativeDirectInstanceFieldCallback.java
 *
 * Created on 12 de febrero de 2004, 20:10
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectInstanceFieldCallback</code> is the interface implemented by
 * native capable classes that make accessible Java instance fields
 * from native as methods. The Java fields are NOT accessed using Java reflection.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature#newDirectInstanceFieldCallback(String)
 */
public interface NativeDirectInstanceFieldCallback extends NativeDirectFieldCallback, NativeInstanceFieldCallback
{
   
}
