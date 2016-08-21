/*
 * NativeMethodCallback.java
 *
 * Created on 1 de abril de 2005, 12:50
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeMethodCallback</code> is the interface implemented by
 * native capable classes that make accessible Java methods
 * from native. Java methods 
 * are called using Java reflection or with a normal call.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeMethodCallback extends NativeCallback,NativeMethod
{
    
}
