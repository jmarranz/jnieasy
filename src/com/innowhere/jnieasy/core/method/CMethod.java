/*
 * NativeStaticMethod.java
 *
 * Created on 12 de febrero de 2004, 20:40
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>CMethod</code> is the interface implemented by
 * native capable classes that make accessible exported C methods of DLLs
 * from Java.
 * <p>
 * The framework has an internal class implementing this interface.
 *
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#addCMethod(String,NativeStaticMethodSignature)
 */
public interface CMethod extends DLLMethod, NativeStaticMethod
{
}
