/*
 * TypeNativePrimitiveObject.java
 *
 * Created on 24 de agosto de 2006, 12:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativePrimitiveObject</code> is the interface that 
 * represents a native type declaration of Java primitive wrappers 
 * and related native wrappers like Boolean, 
 * {@link com.innowhere.jnieasy.core.data.NativeBooleanObject},
 * Character, {@link com.innowhere.jnieasy.core.data.NativeCharacterObject} and so on. 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativePrimitiveObject
 */
public interface TypeNativePrimitiveObject extends TypeCanBeNativeCapable
{
    /** 
     * Returns the associated primitive type.
     *
     * @see TypeNativePrimitive#decObjectWrapper(Class)     
     */
    public TypeNativePrimitive getPrimitiveDec();
}
