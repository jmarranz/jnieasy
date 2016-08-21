/*
 * NativeDirectFieldCallback.java
 *
 * Created on 1 de abril de 2005, 12:48
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeDirectFieldCallback</code> is the interface implemented by
 * native capable classes that make accessible Java fields
 * from native seen as methods. Java fields 
 * are NOT accessed using Java reflection.
 * <p>
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature#newDirectFieldCallback(Field)
 */
public interface NativeDirectFieldCallback extends NativeDirectCallback,NativeFieldCallback
{
    
}
