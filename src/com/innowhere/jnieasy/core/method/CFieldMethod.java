/*
 * CFieldMethod.java
 *
 * Created on 8 de septiembre de 2005, 18:17
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>CFieldMethod</code> is the interface implemented by
 * native capable classes that make accessible exported C fields of DLLs
 * from Java seen as methods.
 * <p>
 * The framework has an internal class implementing this interface.
 *
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#addCFieldMethod(String,NativeStaticFieldMethodSignature)
 */
public interface CFieldMethod extends DLLBehavior, NativeStaticFieldMethod
{
}

