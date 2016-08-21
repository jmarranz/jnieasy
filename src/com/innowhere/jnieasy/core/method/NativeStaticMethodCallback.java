/*
 * NativeStaticMethodCallback.java
 *
 * Created on 12 de febrero de 2004, 19:46
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeStaticMethodCallback</code> is the interface implemented by
 * native capable classes that make accessible Java static methods
 * from native. Java methods are called using Java reflection or normal call.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStaticMethodCallback extends NativeMethodCallback,NativeStaticMethod
{
    /**
     * Method called after marshalling to Java the native call.
     * 
     * 
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     * @see NativeStaticMethod#call(Object[])
     * @see NativeConstructorCallback#onCall(Object[])
     */          
    public Object onCall(Object[] args);  
}
