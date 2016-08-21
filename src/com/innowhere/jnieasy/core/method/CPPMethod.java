/*
 * NativeInstanceMethod.java
 *
 * Created on 12 de febrero de 2004, 20:41
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>CPPMethod</code> is the interface implemented by
 * native capable classes that make accessible C++ exported 
 * instance methods of DLLs from Java.
 * <p>
 * The framework has an internal class implementing this interface.
 *
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#addCPPMethod(String,NativeInstanceMethodSignature)
 */
public interface CPPMethod extends DLLMethod, NativeInstanceMethod
{
}
