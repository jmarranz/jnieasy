/*
 * TypeNativeStaticMethod.java
 *
 * Created on 12 de enero de 2005, 17:28
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeStaticMethod</code> is the interface that 
 * represents a native static method type declaration.
 * <p>
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decStaticMethod(Class,NativeStaticMethodSignature)
 * @see com.innowhere.jnieasy.core.method.NativeStaticMethod
 */
public interface TypeNativeStaticMethod extends TypeNativeMethod
{
    /**
     * Returns the native signature of the declared static method.
     *
     * @return the native signature object.
     */    
    public NativeStaticMethodSignature getStaticMethodSignature();    
}
