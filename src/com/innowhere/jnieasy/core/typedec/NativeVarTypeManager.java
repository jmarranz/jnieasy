/*
 * NativeVarTypeManager.java
 *
 * Created on 11 de mayo de 2005, 11:17
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeVarTypeManager</code> is the interface used to declare native
 * variable types.
 * <p>
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.JNIEasy#getVarTypeManager()
 */
public interface NativeVarTypeManager
{
    /**
     * Returns the utility object to declare native types.
     * 
     * @return the <code>NativeTypeManager</code> object.
     */        
    public NativeTypeManager getTypeManager();
    
    /**
     * Declares the native variable type defined in the specified 
     * expression string.
     * <p>
     * An expression string is based on native type expressions adding
     * info about how this type is addressed as a variable (field member
     * of a structure, a formal method parameter...). 
     * <p>
     * "By pointer" and "by value" conventionalisms are specified with the
     * presence or absence of '*' character in the end of a native type expression. 
     * <p>
     * Anyway, some types are ever "by pointer" and is not necessary to specify 
     * the '*' character. See {@link VarTypeNative#getVarConv()} for a complete list. 
     * <p>
     * Used ClassLoader, parameter <code>importList</code> using, spacing etc is the same as 
     * explained in {@link NativeTypeManager#dec(String,String[])}.
     * <p>
     *
     * <p>
     * Expression examples:
     * <p>
     * <code>"int *"</code><p>  
     * <blockquote>Declares an int pointer. Is equivalent to: 
     * <code>"com.innowhere.jnieasy.core.data.NativeInteger"</code></blockquote>
     * 
     * <code>"mypkg.MyStructure"</code><p>  
     * <blockquote>Declares the user defined mypkg.MyStructure class by value.</blockquote>
     * 
     * <code>"mypkg.MyStructure *"</code><p>  
     * <blockquote>Declares the user defined mypkg.MyStructure class by pointer.</blockquote>
     * 
     * <code>"mypkg.MyStructure **"</code><p>  
     * <blockquote>Declares a pointer to a pointer to mypkg.MyStructure elements. Is equivalent
     * to: <code>Pointer.class.getName() + "{mypkg.MyStructure*}"</code></blockquote>
     * 
     * <code>"mypkg.MyStructure*[3]"</code><p>
     * <blockquote>Declares an array of 3 pointers to mypkg.MyStructure elements, 
     * the array is defined by value.</blockquote>
     * 
     * <code>"mypkg.MyStructure[3]*"</code><p>
     * <blockquote>Declares an array of 3 elements of mypkg.MyStructure by value, 
     * the array is defined by pointer.</blockquote>
     * 
     * <code>"String"</code><p>
     * <blockquote>Declares an ANSI java.lang.String native variable type by pointer.</blockquote>
     * 
     * @param decExpr the expression string defining the native variable type.
     * @param importList the included list of classes using Java import syntax. Can be null.
     * @return the native variable type of the declaration.
     * @see NativeTypeManager#dec(String,String[])
     * @see NativeVarTypeManager#dec(Class,int)
     * @see VarTypeNative#getDeclarationString()
     */
    public VarTypeNative dec(String decExpr,String[] importList);
    
    /**
     * Declares the native variable type defined in the specified expression string.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return dec(decExpr,null);
     * </code></blockquote>
     *
     * @param decExpr the expression string defining the native variable type.
     * @return the native variable type of the declaration.
     * @see #dec(String,String[])
     */    
    public VarTypeNative dec(String decExpr);    
    
    /**
     * Declares the default native variable type of the specified class using
     * the specified variable conventionalism. 
     * <p>
     * This method relies on {@link NativeTypeManager#dec(Class)} to get the default
     * native type declaration of the specified class and 
     * {@link TypeNative#decVarType(int)} to declare the native variable type.<p>
     * 
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().dec(clasz).decVarType(varConv);
     * </code></blockquote>
     * 
     * 
     * @param clasz the class to declare.
     * @param varConv the variable conventionalism.
     * @return the native variable type of the class.
     * @see #dec(TypeNative,int)
     */
    public VarTypeNative dec(Class clasz,int varConv); 
    
    /**
     * Declares the default native variable type of the specified class using
     * the default variable conventionalism of the type. 
     * <p>
     * This method relies on {@link NativeTypeManager#dec(Class)} to get the default
     * native type declaration of the specified class and 
     * {@link TypeNative#decVarType()} to declare the native variable type.<p>
     * 
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().dec(clasz).decVarType();
     * </code></blockquote>
     * 
     * 
     * @param clasz the class to declare.
     * @return the native variable type of the class.
     * @see #dec(Class,int)
     */
    public VarTypeNative dec(Class clasz); 
    
    /**
     * Declares the native variable type of the specified native type using
     * the specified variable conventionalism. 
     * <p>
     * This method relies on {@link TypeNative#decVarType(int)} 
     * to declare the native variable type.<p>
     * 
     * Current implementation is:
     * <blockquote><code>
     * return typeDec.decVarType(varConv);
     * </code></blockquote>
     * 
     * 
     * 
     * @param typeDec the native type base to declare the native variable type.
     * @param varConv the variable conventionalism.
     * @return the native variable type of the class.
     * @see #dec(String,String[])
     */
    public VarTypeNative dec(TypeNative typeDec,int varConv);
    
    /**
     * Declares the native variable type of the specified native type using
     * the default variable conventionalism of the type. 
     * <p>
     * This method relies on {@link TypeNative#decVarType()} 
     * to declare the native variable type.<p>
     * 
     * Current implementation is:
     * <blockquote><code>
     * return typeDec.decVarType();
     * </code></blockquote>
     * 
     * 
     * 
     * @param typeDec the native type base to declare the native variable type.
     * @return the native variable type of the class.
     * @see #dec(TypeNative,int)
     */    
    public VarTypeNative dec(TypeNative typeDec);    
}
