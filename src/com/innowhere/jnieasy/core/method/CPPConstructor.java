/*
 * NativeConstructor.java
 *
 * Created on 12 de febrero de 2004, 20:41
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>CPPConstructor</code> is the interface implemented by
 * native capable classes that make accessible exported C methods of DLLs
 * working as constructors from Java.
 * <p>
 * The framework has an internal class implementing this interface.
 *
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#addCPPConstructor(String,NativeConstructorSignature)
 */
public interface CPPConstructor extends DLLBehavior,NativeConstructor
{
  
}
