/*
 * DLLBehavior.java
 *
 * Created on 13 de enero de 2005, 12:32
 */

package com.innowhere.jnieasy.core.method;
import com.innowhere.jnieasy.core.data.*;

/**
 * The <code>DLLBehavior</code> is the interface implemented by
 * native capable classes that make accessible to Java DLL's exported 
 * fields and methods.
 * <p>
 * A native instance of this type serves as a bridge between the 
 * native world and Java world: the Java world can access a DLL´s 
 * method or field calling a normal Java method; this call is marshalled and
 * converted in a native C/C++ call.
 *
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#addDLLBehavior(String,NativeBehaviorSignature)
 */
public interface DLLBehavior extends NativeCapable,NativeBehavior
{
    
}
