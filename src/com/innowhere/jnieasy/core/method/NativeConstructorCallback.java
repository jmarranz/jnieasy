/*
 * NativeConstructorCallback.java
 *
 * Created on 13 de febrero de 2004, 14:22
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeConstructorCallback</code> is the interface implemented by
 * native capable classes that make accessible Java constructors
 * from native. Java constructors are called using Java reflection or normal call.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeConstructorCallback extends NativeCallback,NativeConstructor
{
    /**
     * Method called after marshalling to Java the native call.
     * <p>
     * The framework defines a default implementation of this method calling
     * the Java method with reflection or with a normal call.
     * <p>
     * If the callback is user defined, this method may be overloaded to 
     * redefine the default process by the framework, or to intercept the
     * call before the normal process (do not forget call the super method).
     *
     * @param args the arguments passed to the constructor.
     * @return the new constructed native object.
     * @see NativeConstructor#call(Object[])
     */        
    public Object onCall(Object[] args);    
}
