/*
 * JNIEasyException.java
 *
 * Created on 21 de noviembre de 2003, 14:13
 */

package com.innowhere.jnieasy.core;

/**
 * <code>JNIEasyException</code> is the <code>java.lang.RuntimeException</code> 
 * derived class used inside JNIEasy to throw exceptions. 
 * Internal exceptions thrown, not RuntimeException derived, 
 * are wrapped to JNIEasyException systematically. 
 * <p>
 * JNIEasyException constructors do not perform 
 * any special processing other submitting parameters to corresponding 
 * RuntimeException constructors.
 *
 * @author  Jose M. Arranz Santamaria 
 */

public class JNIEasyException extends RuntimeException
{
    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     */
    public JNIEasyException()
    {
    }    
    
    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param message the detail message.
     */    
    public JNIEasyException(String message)
    {
        super(message);
    }    

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     */    
    public JNIEasyException(Throwable cause)
    {
        super(cause);
    }      
    
    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).
     */
    public JNIEasyException(String message,Throwable cause)
    {
        super(message,cause);
    }    
}
