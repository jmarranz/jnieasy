/*
 * NativeStaticMethod.java
 *
 * Created on 12 de febrero de 2004, 20:40
 */

package com.innowhere.jnieasy.core.method;
import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>NativeStaticMethod</code> is the interface implemented by
 * native capable classes that bridges Java and native static methods.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStaticMethod extends NativeMethod
{
    /**
     * Returns the native signature of the static method instance.
     *
     * @return the native signature object.
     */       
    public NativeStaticMethodSignature getStaticMethodSignature();
    
    /**
     * Calls the native method.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * Returned value type will match the return native type of the method.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public Object call(Object[] args);
    
    /**
     * Calls the native void method.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     *
     * @param args the arguments passed to the method.
     */    
    public void callVoid(Object[] args);

    /**
     * Calls the native method returning boolean.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return boolean.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */     
    public boolean callBoolean(Object[] args);
    
    /**
     * Calls the native method returning byte.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return byte.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */     
    public byte callByte(Object[] args);
    
    /**
     * Calls the native method returning char.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return char.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public char callChar(Object[] args);
    
    /**
     * Calls the native method returning short.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return short.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public short callShort(Object[] args);

    /**
     * Calls the native method returning int.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return int.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public int callInt(Object[] args);
 
    /**
     * Calls the native method returning long.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return long.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public long callLong(Object[] args);
 
    /**
     * Calls the native method returning float.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return float.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */    
    public float callFloat(Object[] args);
    
    /**
     * Calls the native method returning double.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * The signature of the method called must return double.
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     */     
    public double callDouble(Object[] args);    
    
    /**
     * Calls the native method returning Object.
     * <p>
     * The native type of the method return must be an Object derived type: a "can be native"
     * or a native capable class/interface. 
     *
     * @param args the arguments passed to the method.
     * @return the returned value of the method call.
     * @see #callBoolean(Object[])
     */    
    public Object callObject(Object[] args);
}
