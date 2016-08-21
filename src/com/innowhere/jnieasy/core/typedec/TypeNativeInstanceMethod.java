/*
 * TypeNativeInstanceMethod.java
 *
 * Created on 12 de enero de 2005, 17:28
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeInstanceMethod</code> is the interface that 
 * represents a native instance method type declaration.
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decInstanceMethod(Class,NativeInstanceMethodSignature)
 * @see com.innowhere.jnieasy.core.method.NativeInstanceMethod
 */
public interface TypeNativeInstanceMethod extends TypeNativeMethod
{
    /**
     * Returns the native signature of the declared instance method.
     *
     * @return the native signature object.
     */         
    public NativeInstanceMethodSignature getInstanceMethodSignature();    
}
