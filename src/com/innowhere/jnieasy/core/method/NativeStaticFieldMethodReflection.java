/*
 * NativeStaticFieldMethodReflection.java
 *
 * Created on 1 de diciembre de 2004, 20:02
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeStaticFieldMethodReflection</code> is the interface implemented by
 * native capable classes that make accessible static Java fields
 * from native as methods. The Java fields are accessed using Java reflection.
 * <p>
 * The framework has an internal class implementing this interface.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature#newStaticFieldMethodReflection(Class,String)
 */
public interface NativeStaticFieldMethodReflection extends NativeFieldMethodReflection,NativeStaticFieldCallback
{
}
