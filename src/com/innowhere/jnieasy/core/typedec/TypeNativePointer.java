/*
 * TypeNativePointer.java
 *
 * Created on 30 de septiembre de 2005, 12:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativePointer</code> is the interface that 
 * represents a native type declaration of 
 * {@link com.innowhere.jnieasy.core.data.NativePointer} based classes 
 * (predefined and user defined).
 * <p>
 * Expression syntax if declaring the type using a string with
 * {@link NativeTypeManager#dec(String,String[])} :
 * <p> 
 * <blockquote><code>
 * <i>ClassName</i>[{ <i>PtrVarType</i> }]
 * </code></blockquote>  
 * <p>
 * Where the <code><i>PtrVarType</i></code> is the native variable
 * declaration of the contained pointer. Syntax is defined in 
 * {@link NativeVarTypeManager#dec(String,String[])}.
 * <p>
 * The contained pointer declaration may be not specified in user defined 
 * pointer containers (pointer declaration is implicit to the class), if specified
 * overwrites the default pointer declaration.
 * <p>
 * Spaces may be used as separators when appropriated. 
 * <p>
 * Example: <code>"com.innowhere.jnieasy.core.data.NativePointer {mypkg.MyStructure *}".</code>
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.data.NativePointer
 */
public interface TypeNativePointer extends TypeNativeCapable
{
    /**
     * Returns the native variable type of the internal pointer.
     * 
     * @return the native variable type.
     */
    public VarTypeNative getPointerDec();
}
