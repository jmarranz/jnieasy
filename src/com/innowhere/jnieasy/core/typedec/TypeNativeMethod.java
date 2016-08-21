/*
 * TypeNativeMethod.java
 *
 * Created on 1 de abril de 2005, 12:03
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeMethod</code> is the interface that represents a native
 * method type declaration.
 * <p>
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decMethod(Class,NativeMethodSignature)
 * @see com.innowhere.jnieasy.core.method.NativeMethod
 */
public interface TypeNativeMethod extends TypeNativeBehavior
{
    /**
     * Returns the native signature of the declared method.
     *
     * @return the native signature object.
     */    
    public NativeMethodSignature getMethodSignature();
}
