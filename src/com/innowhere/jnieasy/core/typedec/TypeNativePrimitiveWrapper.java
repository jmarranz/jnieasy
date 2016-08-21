/*
 * TypeNativePrimitiveWrapper.java
 *
 * Created on 24 de agosto de 2006, 12:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativePrimitiveWrapper</code> is the interface that 
 * represents a native type declaration of native wrappers of primitive types
 * (int is wrapped by {@link com.innowhere.jnieasy.core.data.NativeInteger} etc).  
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativePrimitive 
 */
public interface TypeNativePrimitiveWrapper extends TypeNativeCapable
{
    /** 
     * Returns the associated primitive type.
     *
     * @see TypeNativePrimitive#decObjectWrapper(Class)     
     */
    public TypeNativePrimitive getPrimitiveDec();
}
