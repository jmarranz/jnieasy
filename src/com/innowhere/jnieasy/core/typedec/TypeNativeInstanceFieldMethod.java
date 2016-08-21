/*
 * TypeNativeInstanceFieldMethod.java
 *
 * Created on 12 de enero de 2005, 17:28
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeInstanceFieldMethod</code> is the interface that 
 * represents a native instance field-method type declaration.
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decInstanceFieldMethod(Class,NativeInstanceFieldMethodSignature)
 * @see com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod
 */

public interface TypeNativeInstanceFieldMethod extends TypeNativeFieldMethod
{
    /**
     * Returns the native signature of the declared instance field-method.
     *
     * @return the native signature object.
     */        
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature();    
}
