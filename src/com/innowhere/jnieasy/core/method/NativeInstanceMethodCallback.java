/*
 * NativeInstanceMethodCallback.java
 *
 * Created on 12 de febrero de 2004, 20:10
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeInstanceMethodCallback</code> is the interface implemented by
 * native capable classes that make accessible Java instance methods
 * from native. Java methods are called using Java reflection or normal call.
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeInstanceMethodCallback extends NativeMethodCallback,NativeInstanceMethod
{
    /**
     * Method called after marshalling to Java the native call.
     * 
     * 
     * 
     * 
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     * @see NativeInstanceMethod#call(Object,Object[])
     * @see NativeConstructorCallback#onCall(Object[])
     */        
    public Object onCall(Object obj,Object[] args);    
}
