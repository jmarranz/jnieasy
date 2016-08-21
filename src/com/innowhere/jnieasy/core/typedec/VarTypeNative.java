/*
 * TypeNative.java
 *
 * Created on 10 de diciembre de 2004, 9:31
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The native variable type is the interface that represents a native
 * declaration of a field member of a native structure/class/union or
 * a formal parameter of a method. It must be seen as the native type 
 * of the declaration of a variable.
 * <p>
 * This approach tries to mimic in a native world how Java works.
 * Java clearly distinguishes a reference from the object itself:
 * <blockquote><code>
 * NativeStringAnsi str = new NativeStringAnsi();
 * </code></blockquote>
 * The native view of the new NativeStringAnsi object is described with {@link TypeNative}
 * and the native view of the <code>str</code> reference is VarTypeNative. 
 * <p>
 * In Java a reference is ever like a pointer to the object
 * (reference and object are different "variables" on Java memory), 
 * with JNIEasy, a Java reference declared "by value" is not a pointer
 * (using a native memory point of view), 
 * it is the object itself if was declared as a structure field, or
 * represents a copy in the stack native memory of the passed parameter 
 * if was declared as a formal parameter of a method.
 * <p>
 * Returning to the example, if <code>str</code> is a field of a structure
 * (in JNIEasy a C/C++ structure is represented using a user defined Java class),
 * using the same Java semantic, <code>str</code> can access as a pointer to the string
 * addressed (str may be null) if was declared as pointer, or access to 
 * the embedded character array statically allocated in the structure 
 * (<code>str</code> can not be null and must be defined first) if was declared by value.
 * <p>
 * Again, if <code>str</code> is a formal parameter of a method, can
 * represent a pointer to the passed NativeStringAnsi if was declared as a pointer, 
 * or holds itself a char array with a fixed length on the stack and copies
 * the argument (JNIEasy can pass arrays by value).
 * <p>
 * The generic Pointer class (and user defined classes as pointers) 
 * is provided to satisfy the need of more control of the native memory
 * (losing transparency, and "natural" Java programming),
 * avoid it unless you really need it.
 * <p>  
 * Is not mandatory use native wrappers, following the example
 * a String reference can be used instead of the wrapper class as a 
 * <code>char*</code> or <code>char[n]</code> structure field member 
 * or a formal parameter of a method.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */

public interface VarTypeNative
{
    /**
     * Constant used to specify default variable conventionalism.
     *
     * @see #getVarConv()
     */
    public static final int BY_DEFAULT = 0;

    /**
     * Constant used to specify "by pointer" variable conventionalism.
     *
     * @see #getVarConv()
     */    
    public static final int BY_PTR = 1;
    
    /**
     * Constant used to specify "by value" variable conventionalism.
     *
     * @see #getVarConv()
     */        
    public static final int BY_VALUE = 2;    

    /**
     * Returns the native type of this native variable type declaration.
     */
    public TypeNative getType();
    
    /**
     * Returns the native memory size of this native variable type.
     * <p>
     * If the variable type is "by value", the size is the same as
     * the related native type. If "by pointer" the size is the pointer 
     * size of the platform.
     * 
     * @return the native memory size of the variable type.
     * @see TypeNative#size()
     */
    public long size();  
    
    /**
     * Returns the preferred native alignment size of this native variable type.
     * <p>
     * If the variable type is "by value", the alignment size is the same as
     * the related native type. If "by pointer" the size is the pointer 
     * size of the platform.
     * 
     * @return the preferred native alignment size of the variable type.
     * @see TypeNative#preferredAlignSize()
     */    
    public long preferredAlignSize();
    
    /**
     * Returns the variable conventionalism code of this native variable type.     
     * 
     *     <p>
     *     <table border="1" cellpadding="10">
     *     <tr><th width="50%">Native type</th><th>Conventionalisms</th><th>Default</th></tr>
     *     
     *     <tr>     
     *     <td>Primitive</td>
     *     <td>BY_VALUE</td>
     *     <td>BY_VALUE</td>     
     *     </tr>
     *     
     *     <tr>
     *     <td>Primitive wrappers (Integer etc) 
     *     and native wrappers (NativeInteger etc)</td>
     *     <td>BY_PTR</td>
     *     <td>BY_PTR</td>     
     *     </tr>     
     * 
     *     <tr>
     *     <td>String, StringBuffer and wrappers</td>
     *     <td>BY_PTR</td>
     *     <td>BY_PTR</td>
     *     </tr>     
     *     
     *     <tr>
     *     <td>Structure, class or union</td>
     *     <td>Both</td>
     *     <td>BY_PTR</td>
     *     </tr>
     *  
     *     <tr>
     *     <td>Array (normal, wrapper or user defined)</td>
     *     <td>Both</td>
     *     <td>BY_PTR</td> 
     *     </tr>
     *     
     *     <tr>
     *     <td>Pointer or user defined Pointer</td>
     *     <td>BY_PTR</td>
     *     <td>BY_PTR</td>
     *     </tr>
     *     
     *     <tr>
     *     <td>Method (all types)</td>  
     *     <td>BY_PTR</td>
     *     <td>BY_PTR</td>     
     *     </tr>
     *     
     *     </table>
     * 
     * 
     * 
     * @see TypeNative#decVarType(int)
     */
    public int getVarConv();
    
    /** Returns true is variable conventionalism is by value.
     *
     * @return true if conventionalism is by value.
     */
    public boolean byValue();
    
    /** Returns true is variable conventionalism is by pointer.
     *
     * @return true if conventionalism is by pointer.
     */    
    public boolean byPointer();
    
    /**
     * Returns a normalized string representation of the native variable type.
     * <p>
     * The method {@link NativeVarTypeManager#dec(String)} called with this
     * string returns a new native type equals to this.
     * 
     * @return the normalized string of the native variable type.
     * @see TypeNative#getDeclarationString()
     */    
    public String getDeclarationString(); 
    
    /**
     * Returns the utility object to declare native variable types.
     * 
     * @return the <code>NativeVarTypeManager</code> object.
     */    
    public NativeVarTypeManager getVarTypeManager(); 
    
    /**
     * Returns the utility object to declare native types.
     * 
     * @return the <code>NativeTypeManager</code> object.
     */        
    public NativeTypeManager getTypeManager();
    
    /**
     * Declares a native array type using this native variable type 
     * as the element array type and specified dimensions.
     * <p>
     * Current implementation is:
     * <blockquote><pre>
     * return getTypeManager().decArray(dims,this);
     * </pre></blockquote>
     * 
     * @param dims the lengths of the array dimensions.
     * @return the native array type of the declaration.
     * @see NativeTypeManager#decArray(int[],VarTypeNative)
     */        
    public TypeNativeArray decArray(int[] dims); 
    
    /**
     * Declares a one-dimensional native array type using 
     * this native variable type as the element array type 
     * and specified length.
     * <p>
     * Current implementation is:
     * <blockquote><pre>
     * return getTypeManager().decArray(length,this);
     * </pre></blockquote>
     * 
     * @param length the length of the array.
     * @return the native array type of the declaration.
     * @see NativeTypeManager#decArray(int,VarTypeNative)
     */                   
    public TypeNativeArray decArray(int length); 
    
    /**
     * Declares a native pointer type wrapping the specified 
     * declaration of the pointer member.
     * <p>    
     * This native variable declaration must be declared "by pointer".
     * <p>
     * Current implementation is:
     * <blockquote><pre>
     * return getTypeManager().decPointer(this);
     * </pre></blockquote>
     * 
     * @return the native type of the declaration.
     * @see NativeTypeManager#decPointer(VarTypeNative)
     */      
    public TypeNativePointer decPointer();

    /** 
     * Declares a method parameter using this variable type.
     *
     * @return the parameter declaration.
     */
    public NativeParameterDec decParameter();
    
    /** 
     * Declares a method parameter using this variable type and specifing 
     * if the parameter is a variable argument number holder.
     *  
     * Only Java arrays (Object[], char[] etc) are valid to declare
     * vararg parameters.
     *
     * @param varargs if true the parameter is a variable argument number holder.
     * @return the parameter declaration.
     * @see NativeParameterDec#isVarArgs()
     */
    public NativeParameterDec decParameter(boolean varargs);
 
}
