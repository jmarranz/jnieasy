/*
 * NativeInstanceMethodReflection.java
 *
 * Created on 1 de diciembre de 2004, 20:02
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeInstanceMethodReflection</code> is the interface implemented by
 * native capable classes that make accessible Java instance methods
 * from native. The Java methods are called using Java reflection.
 * <p>
 * The framework has an internal class implementing this interface.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.typedec.NativeInstanceMethodSignature#newInstanceMethodReflection(String)
 */
public interface NativeInstanceMethodReflection extends NativeMethodReflection, NativeInstanceMethodCallback
{
    
}
