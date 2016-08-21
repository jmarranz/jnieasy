/*
 * NativeInstanceMethod.java
 *
 * Created on 12 de febrero de 2004, 20:41
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>NativeInstanceMethod</code> is the interface implemented by
 * native capable classes that bridges Java and native instance methods.
 * 
 * @author Jose M. Arranz Santamaria
 */ 
public interface NativeInstanceMethod extends NativeMethod
{
    /**
     * Returns the native signature of the instance method instance.
     *
     * @return the native signature object.
     */     
    public NativeInstanceMethodSignature getInstanceMethodSignature();
    
    /**
     * Calls the native method.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * Returned value type will match the return native type of the method.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public Object call(Object obj,Object[] args);
    
    /**
     * Calls the native void method.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     */     
    public void callVoid(Object obj,Object[] args);

    /**
     * Calls the native method returning boolean.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return boolean.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */     
    public boolean callBoolean(Object obj,Object[] args);
    
    /**
     * Calls the native method returning byte.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return byte.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public byte callByte(Object obj,Object[] args);
    
    /**
     * Calls the native method returning char.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return char.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public char callChar(Object obj,Object[] args);
    
    /**
     * Calls the native method returning short.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return short.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public short callShort(Object obj,Object[] args);

    /**
     * Calls the native method returning int.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return int.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public int callInt(Object obj,Object[] args);
 
    /**
     * Calls the native method returning long.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return long.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public long callLong(Object obj,Object[] args);
 
    /**
     * Calls the native method returning float.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return float.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public float callFloat(Object obj,Object[] args);
    
    /**
     * Calls the native method returning double.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return double.
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public double callDouble(Object obj,Object[] args);
    
    /**
     * Calls the native method returning Object.
     * <p>
     * The native type of the method return must be an Object derived type: a "can be native"
     * or a native capable class/interface. 
     *
     * @param obj the native capable object containing the method.
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     * @see #callBoolean(Object,Object[])
     */    
    public Object callObject(Object obj,Object[] args);
}
