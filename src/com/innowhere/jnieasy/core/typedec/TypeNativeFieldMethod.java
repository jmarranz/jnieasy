/*
 * TypeNativeFieldMethod.java
 *
 * Created on 1 de abril de 2005, 12:03
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeFieldMethod</code> is the interface that represents a native
 * field-method type declaration.
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decFieldMethod(Class,NativeFieldMethodSignature)
 * @see com.innowhere.jnieasy.core.method.NativeFieldMethod
 */
public interface TypeNativeFieldMethod extends TypeNativeBehavior
{
    /**
     * Returns the native signature of the declared field-method.
     *
     * @return the native signature object.
     */       
    public NativeFieldMethodSignature getFieldMethodSignature();
}
