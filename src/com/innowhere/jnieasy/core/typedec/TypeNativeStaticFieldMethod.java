/*
 * TypeNativeStaticFieldMethod.java
 *
 * Created on 12 de enero de 2005, 17:28
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeStaticFieldMethod</code> is the interface that 
 * represents a native static field-method type declaration.
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decStaticFieldMethod(Class,NativeStaticFieldMethodSignature)
 * @see com.innowhere.jnieasy.core.method.NativeStaticFieldMethod
 */
public interface TypeNativeStaticFieldMethod extends TypeNativeFieldMethod
{
    /**
     * Returns the native signature of the declared static field-method.
     *
     * @return the native signature object.
     */    
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature();    
}
