/*
 * NativeInstanceFieldMethodReflection.java
 *
 * Created on 1 de diciembre de 2004, 20:02
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeInstanceFieldMethodReflection</code> is the interface implemented by
 * native capable classes that make accessible Java instance fields
 * from native as methods. The Java fields are accessed using Java reflection.
 * <p>
 * The framework has an internal class implementing this interface.
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature#newInstanceFieldMethodReflection(String)
 */
public interface NativeInstanceFieldMethodReflection extends NativeFieldMethodReflection,NativeInstanceFieldCallback
{

}
