/*
 * JNIEasyNativeException.java
 *
 * Created on 21 de julio de 2006, 14:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core;

/**
 * <code>JNIEasyNativeException</code> is the {@link JNIEasyException} 
 * derived class thrown from native code. 
 * 
 * The native part of JNIEasy
 * catches any type of native exceptions (calling native methods or accessing
 * native memory), and throws an exception of this class, 
 * avoiding a JVM crash. 
 *
 * @author  Jose M. Arranz Santamaria
 */
public class JNIEasyNativeException extends JNIEasyException
{
    
    /** Creates a new instance of JNIEasyNativeException */
    public JNIEasyNativeException(String message)
    {
        super(message);
    }
    
}
