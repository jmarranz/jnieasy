/*
 * TypeNativePrimitive.java
 *
 * Created on 6 de marzo de 2006, 17:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativePrimitive</code> is the interface that represents a native
 * type declaration of a primitive data type (boolean, byte, char, short, 
 * int, long, float, double).
 * <p>
 * Expression syntax if declared the type using a string with
 * {@link NativeTypeManager#dec(String,String[])} or
 * with {@link NativeTypeManager#decPrimitive(Class,String,String)} :
 * <p>
 * <blockquote><code>
 * <i>PrimitiveTypeName</i> [{<i>MemSizeAndAlignDec</i>}]
 * </code></blockquote> 
 *
 * Where <i>MemSizeAndAlignDec</i> is defined as:
 * <blockquote><code>
 * <i>MemSizeDecList</i>[,<i>AlignSizeDecList</i>]
 * </code></blockquote>
 *
 * <i>MemSizeDecList</i> is the memory size of the primitive type and <i>AlignSizeDecList</i> 
 * is the preferred alignment, if the alignment is not specified the memory size
 * declared is used as alignment too. The format of both expressions
 * is documented in {@link NativeTypeManager#parseMemorySizeWithMacros(String)}.
 *
 * Examples:
 * <ul>
 *  <li>
 *      <code>"8"</code>
 *      <blockquote>The memory size is 8, the alignment is unspecified 
 *      (will be the same as the declared memory size: 8)
 *      </blockquote> 
 *  </li>
 *  <li>
 *      <code>"8, 4"</code>
 *      <blockquote>The memory size is 3 and the preferred alignment 4.
 *      </blockquote> 
 *  </li>
 *  <li>
 *      <code>"MSC:4;gcc:8;REGISTER_SIZE"</code>
 *      <blockquote>The memory size is 4 if the "MSC" macro was defined,
 *      else is 8 if the "gcc" macro was defined, else the value of the
 *      "REGISTER_SIZE" macro is used (must be defined with an integer value).
 *      The alignment is unspecified (will be the same as the declared memory size).
 *      </blockquote> 
 *  </li>
 * </ul>
 *
 *
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decPrimitive(Class,long,long)
 * @see NativeTypeManager#parseMemorySizeWithMacros(String)
 */
public interface TypeNativePrimitive extends TypeNative
{
    /**
     * Declares a native wrapper type of this primitive type.
     * <p>
     * For instance: if this type is "boolean", the declared data type
     * can be <code>Boolean</code> (the Java wrapper), <code>NativeBoolean</code> 
     * and <code>NativeBooleanObject</code>,
     * native instances of these data types are "addressed booleans" and native references
     * are "pointer to boolean".
     *
     * @param clasz the class used to wrap the primitive type.
     * @return the native wrapper type.
     */
    public TypeNativeObject decObjectWrapper(Class clasz);
}
