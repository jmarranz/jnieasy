/*
 * DLLMethod.java
 *
 * Created on 17 de septiembre de 2005, 15:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>DLLMethod</code> is the interface implemented by
 * native capable classes that make accessible exported methods of DLLs
 * from Java.
 *
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#addDLLMethod(String,NativeMethodSignature)
 */
public interface DLLMethod extends DLLBehavior,NativeMethod
{
    
}
