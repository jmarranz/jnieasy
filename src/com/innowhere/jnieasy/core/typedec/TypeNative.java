/*
 * TypeNative.java
 *
 * Created on 10 de diciembre de 2004, 9:31
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNative</code> is the interface that represents a native
 * type declaration using native capable classes (user defined or predefined).
 * <p>
 * This native type must be seen as the type used in 
 * a C++ <code>new</code> sentence, it does not include any kind of 
 * "parameter pass/variable conventionalism" (by value or by pointer) 
 * used in C/C++ structure fields (and classes and unions) 
 * or formal parameters of methods. 
 * <p>
 * 
 * @author Jose M. Arranz Santamaria
 * @see VarTypeNative
 * @see NativeTypeManager#dec(Class)
 */
public interface TypeNative
{
    /**
     * Returns the size of the native memory of an instance of this native type.
     * <p>
     * If the type is a native string or a undefined length array, 
     * the size is unknown and an exception is thrown.
     * <p>
     * If primitive or primitive wrapper (e.g. NativeBoolean, NativeBooleanObject) 
     * the returned size is the Java size of the primitive type. This size is
     * platform independent (e.g. boolean=1,char=2,int=4...) unless
     * changed "per type instance" using {@link NativeTypeManager#decPrimitive(Class,long)}
     * or globally using methods like {@link NativeTypeManager#setDefaultBooleanSize(long)}.
     *
     * @return the size of the native memory of the type.
     * @see NativeClassDescriptor#size()
     */
    public long size();  
    
    /**
     * Returns the preferred native alignment size of the native type,
     * returns the alignment size of an instance of this native type.
     * <p>
     * This value is used to calculate the relative offsets of the fields
     * of native structures, classes and unions, and may be replaced with
     * a specificated field alignment or global structure alignment.    
     *
     <table border="1" cellpadding="10">
     <tr><th width="25%">Native type</th><th>Alignment size</th></tr>
     
     <tr>     
     <td>Primitive</td>
     <td>The alignment size is the "natural" alignment size of the
     Java primitive seen as JNI data type (e.g. jint), usually this value is 
     the same as the memory size. May be changed "per type instance" with
     methods like {@link NativeTypeManager#decPrimitive(Class,long,long)}
     or globally using methods like {@link NativeTypeManager#setDefaultBooleanSize(long,long)}.
     </td>
     </tr>

     <tr>
     <td>Primitive wrappers (Integer etc) 
     and native wrappers (NativeInteger etc)</td>
     <td>The alignment size of the wrapped primitive type</td>
     </tr>     
          
     <tr>
     <td>String, StringBuffer and wrappers</td>
     <td>The alignment size of the native char type used 
     (1 if ANSI, the platform wchar_t size if UNICODE)</td>
     </tr>
          
     <tr>
     <td>Structure, class or union</td>
     <td>The maximum alignment of fields</td>
     </tr>
     
     <tr>
     <td>Array (normal, wrapper or user defined)</td>
     <td>The alignment size of the component type of the array</td>     
     </tr>
     
     <tr>
     <td>Pointer or user defined Pointer</td>
     <td>The pointer size of the platform</td>
     </tr>
     
     <tr>
     <td>Method (all types)</td>  
     <td>Undefined, an exception is thrown because memory size of the method 
     is ever unknown and a method is never declared by value 
     (the alignment size of a method field is ever the pointer size)
     </td>     
     </tr>
     
     </table>
     *
     * @return the size of the preferred alignment size of the type.
     * @see NativeClassDescriptor#alignSize()
     * @see NativeFieldStructureDescriptor#alignSize()
     */    
    public long preferredAlignSize();
    
    /**
     * Returns the Java class used to declare the native type.
     *
     * @return the class of the native type.
     */
    public Class getDeclaredClass();
    
    /**
     * Returns a normalized string representation of the native type.
     * <p>
     * The method {@link NativeTypeManager#dec(String)} called with this
     * string returns a new native type equals to this.
     * 
     * 
     * @return the normalized string of the native type.
     * @see VarTypeNative#getDeclarationString()
     */
    public String getDeclarationString();  
    
    /**
     * Returns a native variable type declaration using this native type
     * and the specified variable conventionalism.
     * <p>
     * If the conventionalism is not compatible with the native type, an exception
     * is thrown.
     * 
     * 
     * @return the a native variable type declaration.
     * @see VarTypeNative#getVarConv()
     * @see VarTypeNative#BY_DEFAULT
     * @see VarTypeNative#BY_PTR
     * @see VarTypeNative#BY_VALUE
     */ 
    public VarTypeNative decVarType(int varConv);
    
    /**
     * Returns a native variable type declaration using this native type
     * and the default variable conventionalism of the native type.
     * 
     * 
     * @return the native variable type declaration
     * @see VarTypeNative#getVarConv()
     */    
    public VarTypeNative decVarType(); 
}
