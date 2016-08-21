/*
 * NativeSignatureManager.java
 *
 * Created on 6 de abril de 2005, 18:13
 */

package com.innowhere.jnieasy.core.typedec;

import java.lang.reflect.*;

/**
 * The <code>NativeSignatureManager</code> is the interface used to declare signatures
 * of native methods.
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.JNIEasy#getSignatureManager()
 */

public interface NativeSignatureManager
{
    /** 
     * Returns the default calling conventionalism of native methods when 
     * declaring and is not specified.
     *
     * @return the default calling conventionalism of native methods.
     * @see CallConv#STD_CALL
     * @see CallConv#C_CALL
     * @see #setDefaultCallConv(int)
     */
    public int getDefaultCallConv();

    /** 
     * Sets the default calling conventionalism of native methods when 
     * declaring and is not specified.
     * 
     * @param callConv the new default calling conventionalism of native methods.
     * @see #getDefaultCallConv()
     */
    public void setDefaultCallConv(int callConv);    
    
    /** 
     * Declares a method parameter using the specified variable type.
     *
     * Current implementation is:
     * <blockquote><pre>
     * return paramVarType.decParameter();
     * </pre></blockquote>     
     *
     * @param paramVarType the variable type of the parameter.
     * @return the parameter declaration.
     * @see VarTypeNative#decParameter()
     */
    public NativeParameterDec decParameter(VarTypeNative paramVarType);
    
    /** 
     * Declares a method parameter using the specified variable type and specifying  
     * if the parameter is a variable argument number holder (varargs).
     *
     * Current implementation is:
     * <blockquote><pre>
     * return paramVarType.decParameter(varargs);
     * </pre></blockquote>     
     *
     * @param paramVarType the variable type of the parameter.
     * @param varargs if true the parameter is a variable argument number holder.
     * @return the parameter declaration.
     * @see VarTypeNative#decParameter(boolean)
     */
    public NativeParameterDec decParameter(VarTypeNative paramVarType,boolean varargs);

    
    /**
     * Declares a native method signature defined in the specified 
     * expression string.
     * <p>
     * The expression string follows a special syntax mixing Java and C/C++.
     * <p>
     * Used ClassLoader, parameter <code>importList</code> using, spacing etc are the same as 
     * explained in {@link NativeTypeManager#dec(String,String[])}.
     * <p>
     * Syntax:
     * <blockquote><code>
     * [static] [<i>ReturnType</i>] [<i>callConv</i>] [<i>ClassName</i>] [([<i>param</i>[,<i>param</i>]...])]
     * </code></blockquote>
     * Where:
     * <p>
     * <code>static</code> : if declared the method is static.
     * <p>
     * <code><i>ReturnType</i></code> : the native variable type expression of the return.
     * <p>
     * <code><i>callConv</i></code> : method call convention, possible values are 
     * <a href="http://msdn.microsoft.com/library/en-us/vclang/html/_core___stdcall.asp">
     * <code>__stdcall</code>
     * </a> 
     * and 
     * <a href="http://msdn.microsoft.com/library/en-us/vclang/html/_core___cdecl.asp">
     * <code>__cdecl</code>
     * </a> 
     * (same literals and meaning as VisualC++). If not declared, the framework
     * default is used (see {@link #getDefaultCallConv()}).
     * <p>
     * <code><i>ClassName</i></code> : container Java native class of the method (or field). 
     * Only when a constructor or instance signature is declared.
     * <p>
     * <code><i>param</i></code> : native variable type expression of the parameter.
     * <p>
     * Cases: 
     * <p>
     * 1) Static methods:
     * <blockquote><code>
     * static <i>ReturnType</i> [<i>callConv</i>] (...)
     * </code></blockquote>
     * 2) Constructors:
     * <blockquote><code>
     * [<i>callConv</i>] <i>ClassName</i>(...)
     * </code></blockquote>
     * 3) Instance methods:
     * <blockquote><code>
     * <i>ReturnType</i> [<i>callConv</i>] <i>ClassName</i>(...)
     * </code></blockquote>
     * <p>
     * 4) Static field-methods:
     * <blockquote><code>
     * static <i>ReturnType</i> [<i>callConv</i>]
     * </code></blockquote>
     * 5) Instance field-methods:
     * <blockquote><code>
     * static <i>ReturnType</i> [<i>callConv</i>] <i>ClassName</i>
     * </code></blockquote>
     * 
     * Syntax of native variable types is explained in {@link NativeTypeManager#dec(String,String[])}.
     * <p>
     * Expression examples:
     * <p>
     * <code>"static int [][]* __stdcall (int, java.lang.Boolean, java.lang.String[10], long [][]* , mypkg.MyClass[5])"</code><p>  
     * <blockquote>Declares a static method using the standard call convention.</blockquote>
     * 
     * <code>"mypkg.MyClass[5]* mypkg.MyClass( int, double)"</code>
     * <blockquote>Declares a instance method using the default call convention.</blockquote>
     * 
     * <code>"mypkg.MyClass(int, double)"</code>
     * <blockquote>Declares a constructor using the default call convention.</blockquote>
     * 
     * <code>"static int  __cdecl "</code>
     * <blockquote>Declares a method to access a static field of int type using the C call convention.</blockquote>
     * 
     * <code>"int  __cdecl mypkg.MyClass"</code>
     * <blockquote>Declares a method to access a instance field of int type of the native class mypkg.MyClass using the C call convention.</blockquote>
     * 
     * 
     * @param decExpr the expression string defining the native signature.
     * @param importList the included list of classes using Java import syntax. Can be null.
     * @return the native signature of the declaration.
     * @see NativeVarTypeManager#dec(String,String[])
     * @see NativeBehaviorSignature#getDeclarationString()
     */
    public NativeBehaviorSignature decBehavior(String decExpr,String[] importList);           
    
    /**
     * Declares the native method signature defined in the specified expression string.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return dec(decExpr,null);
     * </code></blockquote>
     *
     * @param decExpr the expression string defining the native signature.
     * @return the native signature of the declaration.
     * @see #decBehavior(String,String[])
     */        
    public NativeBehaviorSignature decBehavior(String decExpr);    

    /**
     * Declares a native constructor signature.
     * <p>
     * The constructor declaration needs the container class, 
     * the native variable types of the parameters and the call convention
     * using the constants declared in {@link CallConv}.
     * <p>
     * Each element of the array <code>params</code> is a parameter
     * declaration, index of the array is coincident with the 
     * corresponding index of the parameter starting in left.
     * It is a native variable type declaration specified as: 
     * <ul>
     *  <li>A {@link NativeParameterDec} object.
     *  <li>A {@link VarTypeNative} object: the native parameter object is
     *      the result of calling to {@link VarTypeNative#decParameter()}.
     *  <li>A Class object: the native variable type is the result of calling
     *       to {@link NativeVarTypeManager#dec(Class)}.
     *  <li>A String object: the native variable type is the result of calling
     *       to {@link NativeVarTypeManager#dec(String)}.
     * </ul>
     *
     * @param clasz defines the container class of the constructor (and return type).
     * @param params parameter list declaration. 
     * @param callConv call convention of the method.
     * @return the native constructor signature.
     * @see #decBehavior(String)
     */
    public NativeConstructorSignature decConstructor(Class clasz,Object[] params,int callConv);    
    
    /**
     * Declares a native constructor signature with the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decConstructor(clasz,params,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param clasz defines the container class of the constructor (and return type).
     * @param params parameter list declaration. 
     * @return the native constructor signature.
     * @see #decConstructor(Class,Object[])
     */    
    public NativeConstructorSignature decConstructor(Class clasz,Object[] params);
    
    /**
     * Declares a native constructor signature of the specified constructor
     * reflection object.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decConstructor(constructor.getDeclaringClass(),constructor.getParameterTypes(),callConv);
     * </code></blockquote>
     *
     * @param constructor the constructor reflection object.
     * @param callConv call convention of the method.
     * @return the native constructor signature.
     * @see #decConstructor(Class,Object[],int)
     */ 
    public NativeConstructorSignature decConstructor(Constructor constructor,int callConv);
    
    /**
     * Declares a native constructor signature of the specified constructor
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decConstructor(constructor,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param constructor the constructor reflection object.
     * @return the native constructor signature.
     * @see #decConstructor(Constructor)
     */     
    public NativeConstructorSignature decConstructor(Constructor constructor);

    /**
     * Declares a native method signature.
     * <p>
     * Current implementation is:
     * <blockquote><code><pre>
     * if (clasz == null)
     *     return decStaticMethod(returnType,params,callConv);
     * else
     *     return decInstanceMethod(clasz,returnType,params,callConv);
     * </pre></code></blockquote>
     * 
     * 
     * 
     * @param clasz defines the container class of the method. Can be null.
     * @param returnType the return type declaration.
     * @param params parameter list declaration.
     * @param callConv call convention of the method.
     * @return the native method signature.
     * @see #decBehavior(String)
     * @see #decStaticMethod(Object,Object[],int)
     * @see #decInstanceMethod(Class,Object,Object[],int)
     */    
    public NativeMethodSignature decMethod(Class clasz,Object returnType,Object[] params, int callConv);    
    
    /**
     * Declares a native method signature using the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decMethod(clasz,returnType,params,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param clasz defines the container class of the method. Can be null.
     * @param returnType the return type declaration.
     * @param params parameter list declaration. 
     * @return the native method signature.
     * @see #decMethod(Class,Object,Object[],int)
     */    
    public NativeMethodSignature decMethod(Class clasz,Object returnType,Object[] params);    
    
    /**
     * Declares a native method signature of the specified method
     * reflection object.
     * <p>
     * Current implementation is:
     * <blockquote><code><pre>
     * if (Modifier.isStatic(method.getModifiers()))
     *     return decStaticMethod(method,callConv);
     * else 
     *     return decInstanceMethod(method,callConv);
     * </pre></code></blockquote>
     * 
     * 
     * 
     * @param method the method reflection object.
     * @param callConv call convention of the method.
     * @return the native method signature.
     * @see #decStaticMethod(Method,int)
     * @see #decInstanceMethod(Method,int)
     */     
    public NativeMethodSignature decMethod(Method method,int callConv);
    
    /**
     * Declares a native method signature of the specified method
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decMethod(method,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param method the method reflection object.
     * @return the native method signature.
     * @see #decMethod(Method)
     */         
    public NativeMethodSignature decMethod(Method method);
    
    /**
     * Declares a native static method signature.
     * <p>
     * The method declaration needs the
     * native variable type of return and parameters
     * and the call convention using the constants declared in 
     * {@link CallConv}.
     * <p>
     * The <code>returnType</code> and elements of <code>params</code>
     * follows the same rules as parameters of the constructor
     * declaration of method {@link #decConstructor(Class,Object[],int)}.
     *
     * @param returnType the return type declaration.
     * @param params parameter list declaration. 
     * @param callConv call convention of the method.
     * @return the native method signature.
     * @see #decMethod(Class,Object,Object[],int)
     */    
    public NativeStaticMethodSignature decStaticMethod(Object returnType,Object[] params,int callConv);    
    
    /**
     * Declares a native static method signature using the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStaticMethod(returnType,params,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param returnType the return type declaration.
     * @param params parameter list declaration. 
     * @return the native method signature.
     * @see #decStaticMethod(Object,Object[],int)
     */        
    public NativeStaticMethodSignature decStaticMethod(Object returnType,Object[] params);
    
    /**
     * Declares a native static method signature of the specified method
     * reflection object.
     * <p>
     * Current implementation checks if <code>method</code> is static
     * then calls:
     * <blockquote><code>
     * return decStaticMethod(method.getReturnType(),method.getParameterTypes(),callConv);
     * </code></blockquote>
     *
     * @param method the method reflection object.
     * @param callConv call convention of the method.
     * @return the native static method signature.
     * @see #decStaticMethod(Object,Object[],int)
     */ 
    public NativeStaticMethodSignature decStaticMethod(Method method,int callConv);    
    
    /**
     * Declares a native static method signature of the specified method
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStaticMethod(method,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param method the method reflection object.
     * @return the native static method signature.
     * @see #decStaticMethod(Method)
     */             
    public NativeStaticMethodSignature decStaticMethod(Method method);
    
    /**
     * Declares a native instance method signature.
     * <p>
     * The method declaration needs the container class, the 
     * native variable type of return and parameters
     * and the call convention using the constants declared in 
     * {@link CallConv}.
     * <p>
     * The <code>returnType</code> and elements of <code>params</code>
     * follows the same rules as parameters of the constructor
     * declaration of method {@link #decConstructor(Class,Object[],int)}.
     *
     * @param clasz the container class of the method.
     * @param returnType the return type declaration.
     * @param params parameter list declaration. 
     * @param callConv call convention of the method.
     * @return the native instance method signature.
     * @see #decMethod(Class,Object,Object[],int)
     */    
    public NativeInstanceMethodSignature decInstanceMethod(Class clasz,Object returnType,Object[] params, int callConv);    
    
    /**
     * Declares a native static method signature using the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decInstanceMethod(clasz,returnType,params,getDefaultCallConv());
     * </code></blockquote>
     * 
     * 
     * 
     * @param clasz the container class of the method.
     * @param returnType the return type declaration.
     * @param params parameter list declaration.
     * @return the native instance method signature.
     * @see #decInstanceMethod(Class,Object,Object[],int)
     */            
    public NativeInstanceMethodSignature decInstanceMethod(Class clasz,Object returnType,Object[] params);
    
    /**
     * Declares a native instance method signature of the specified method
     * reflection object.
     * <p>
     * Current implementation checks if <code>method</code> is not static
     * then calls:
     * <blockquote><code>
     * return decInstanceMethod(method.getDeclaringClass(),method.getReturnType(),method.getParameterTypes(),callConv);
     * </code></blockquote>
     * 
     * 
     * @param method the method reflection object.
     * @param callConv call convention of the method.
     * @return the native static method signature.
     * @see #decInstanceMethod(Class,Object,Object[],int)
     */    
    public NativeInstanceMethodSignature decInstanceMethod(Method method,int callConv);    
    
    /**
     * Declares a native instance method signature of the specified method
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decInstanceMethod(method,getDefaultCallConv());
     * </code></blockquote>
     * 
     * 
     * 
     * @param method the method reflection object.
     * @return the native instance method signature.
     * @see #decInstanceMethod(Method)
     */                 
    public NativeInstanceMethodSignature decInstanceMethod(Method method);
   
    /**
     * Declares a native field-method signature.
     * <p>
     * Current implementation is:
     * <blockquote><code><pre>
     * if (clasz == null)
     *     return decStaticFieldMethod(fieldType,callConv);
     * else
     *     return decInstanceFieldMethod(clasz,fieldType,callConv);
     * </pre></code></blockquote>
     * 
     * 
     * 
     * @param clasz defines the container class of the field.
     * @param fieldType the native field type declaration.
     * @param callConv call convention of the method.
     * @return the native field-method signature.
     * @see #decBehavior(String)
     * @see #decStaticFieldMethod(Object,int)
     * @see #decInstanceFieldMethod(Class,Object,int)
     */        
    public NativeFieldMethodSignature decFieldMethod(Class clasz,Object fieldType, int callConv);     
    
    /**
     * Declares a native field-method signature using the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decFieldMethod(clasz,fieldType,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param clasz defines the container class of the field.
     * @param fieldType the native field type declaration.
     * @return the native method signature.
     * @see #decMethod(Class,Object,Object[],int)
     */        
    public NativeFieldMethodSignature decFieldMethod(Class clasz,Object fieldType);   
    
    /**
     * Declares a native field-method signature of the specified field
     * reflection object.
     * <p>
     * Current implementation is:
     * <blockquote><code><pre>
     * if (Modifier.isStatic(field.getModifiers()))
     *     return decStaticFieldMethod(field,callConv);
     * else 
     *     return decInstanceFieldMethod(field,callConv);
     * </pre></code></blockquote>
     * 
     * 
     * 
     * @param field the field reflection object.
     * @param callConv call convention of the method.
     * @return the native field-method signature.
     * @see #decStaticFieldMethod(Field,int)
     * @see #decInstanceFieldMethod(Field,int)
     */
    public NativeFieldMethodSignature decFieldMethod(Field field,int callConv);    
    
    /**
     * Declares a native field-method signature of the specified field
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decFieldMethod(field,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param field the field reflection object.
     * @return the native field-method signature.
     * @see #decFieldMethod(Field)
     */     
    public NativeFieldMethodSignature decFieldMethod(Field field);
    
    /**
     * Declares a native static field-method signature.
     * <p>
     * The field-method declaration needs the
     * native variable type of field 
     * and the call convention using the constants declared in 
     * {@link CallConv}.
     * <p>
     * The <code>fieldType</code> 
     * follows the same rules as parameters of the constructor
     * declaration of method {@link #decConstructor(Class,Object[],int)}.
     *
     * @param fieldType the native field type declaration.
     * @param callConv call convention of the field-method.
     * @return the native field-method signature.
     * @see #decFieldMethod(Class,Object,int)
     */    
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Object fieldType,int callConv);    
    
    /**
     * Declares a native static field-method signature using the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStaticFieldMethod(fieldType,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param fieldType the native field type declaration.
     * @return the native field-method signature.
     * @see #decStaticFieldMethod(Object,int)
     */    
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Object fieldType);
    
    /**
     * Declares a native static field-method signature of the specified field
     * reflection object.
     * <p>
     * Current implementation checks if <code>field</code> is static
     * then calls:
     * <blockquote><code>
     * return decStaticFieldMethod(field.getType(),callConv);
     * </code></blockquote>
     *
     * @param field the field reflection object.
     * @param callConv call convention of the method.
     * @return the native static field-method signature.
     * @see #decStaticFieldMethod(Object,int)
     */
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Field field,int callConv);    
    
    /**
     * Declares a native static field-method signature of the specified field
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStaticFieldMethod(field,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param field the field reflection object.
     * @return the native static field-method signature.
     * @see #decStaticFieldMethod(Field)
     */    
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Field field);
    
    /**
     * Declares a native instance field-method signature.
     * <p>
     * The field-method declaration needs the container class, the 
     * native variable type of field
     * and the call convention using the constants declared in 
     * {@link CallConv}.
     * <p>
     * The <code>fieldType</code> 
     * follows the same rules as parameters of the constructor
     * declaration of method {@link #decConstructor(Class,Object[],int)}.
     *
     * @param clasz the container class of the field.
     * @param fieldType the native field type declaration.
     * @param callConv call convention of the method.
     * @return the native instance field-method signature.
     * @see #decFieldMethod(Class,Object,int)
     */        
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Class clasz,Object fieldType, int callConv);    
    
    /**
     * Declares a native static field-method signature using the default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decInstanceFieldMethod(clasz,fieldType,getDefaultCallConv());
     * </code></blockquote>
     * 
     * 
     * 
     * @param clasz the container class of the field.
     * @param fieldType the native field type declaration.
     * @return the native instance field-method signature.
     * @see #decInstanceFieldMethod(Class,Object,int)
     */     
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Class clasz,Object fieldType);
    
    /**
     * Declares a native instance field-method signature of the specified field
     * reflection object.
     * <p>
     * Current implementation checks if <code>field</code> is not static
     * then calls:
     * <blockquote><code>
     * return decInstanceFieldMethod(field.getDeclaringClass(),field.getType(),callConv);
     * </code></blockquote>
     * 
     * 
     * 
     * @param field the field reflection object.
     * @param callConv call convention of the method.
     * @return the native static field-method signature.
     * @see #decInstanceFieldMethod(Class,Object,int)
     */      
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Field field,int callConv);    
    
    /**
     * Declares a native instance field-method signature of the specified field
     * reflection object and default call convention.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decInstanceFieldMethod(field,getDefaultCallConv());
     * </code></blockquote>
     * 
     * 
     * 
     * @param field the field reflection object.
     * @return the native instance field-method signature.
     * @see #decInstanceFieldMethod(Field)
     */    
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Field field);
}
