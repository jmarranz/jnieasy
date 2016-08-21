/*
 * MethodSignature.java
 *
 * Created on 4 de febrero de 2004, 20:19
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.mem.NativeAddress;
import com.innowhere.jnieasy.core.method.NativeBehaviorReflection;
import com.innowhere.jnieasy.core.method.NativeDirectCallback;
import com.innowhere.jnieasy.core.method.NativeBehavior;
import java.lang.reflect.Member;

/**
 * The <code>NativeBehaviorSignature</code> interface represents
 * the native signature declaration of all method types. 
 * <p>
 * Describes how a method must be called using a native call.
 * The parameters and return type are declared using
 * native variable types, and the native container of the method 
 * is declared with a native class (needed if instance or constructor).
 * <p>
 * Method and parameter names are not needed, 
 * as a matter of fact a signature may be declared without 
 * a real concrete Java method supporting it (with the exception of 
 * constructors).
 * <p>
 * Signatures are declared using {@link NativeSignatureManager} methods.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */

public interface NativeBehaviorSignature
{
    /**
     * Returns the utility object to declare native types.
     * 
     * 
     * 
     * @return the <code>NativeTypeManager</code> object.
     */        
    public NativeTypeManager getTypeManager();
    
    /**
     * Returns the conventionalism used to call methods. 
     *
     * @return the conventionalism value.
     * @see CallConv#C_CALL
     * @see CallConv#STD_CALL
     */
    public int getCallConv();
    
    /**
     * Returns the declared parameters.
     * <p>
     * Modifications of the returned array have not effect.
     *
     * @return an array with the parameter declaration list.
     */
    public VarTypeNative[] getParameters();
    
    /**
     * Returns the number of declared parameters.
     *
     * @return the number of declared parameters.
     */    
    public int getParameterCount();
    
    /**
     * Returns a string representation of the native signature declaration.
     * <p>
     * This string may be used as a parameter <code>decExpr</code> of 
     * {@link NativeSignatureManager#decBehavior(String,String[])}
     *
     * @return the string representation of the native signature.
     */ 
    public String getDeclarationString(); 
    
    /**
     * Returns a string representation of the native signature using
     * the specified method/field name.
     * <p>
     * This method is useful to view how is registered a native method 
     * instance in a DLL using {@link com.innowhere.jnieasy.core.mem.DynamicLibrary#addDLLBehavior(String,NativeBehaviorSignature)}
     * or {@link com.innowhere.jnieasy.core.mem.JNIEasyLibrary#exportBehavior(String,NativeBehavior)}
     * <p>
     * The returned string follows the following format:
     * <p>
     * <ul>
     *   <li>Constructor:
     *     <blockquote><code>
     *     <i>ClassName</i>.<init>(<i>ParamsDec</i>)
     *     </code></blockquote>
     *   </li>
     *   <li>Static method:  
     *     <blockquote><code>
     *     <i>name</i>(<i>ParamsDec</i>)
     *     </code></blockquote>
     *   </li>
     *   <li>Instance method:  
     *     <blockquote><code>
     *     <i>ClassName</i>.<i>name</i>(<i>ParamsDec</i>)
     *     </code></blockquote>
     *   </li>
     *   <li>Static field-method:  
     *     <blockquote><code>
     *     <i>name</i>(int,<i>FieldDec</i>)
     *     </code></blockquote>
     *   </li>
     *   <li>Instance field-method:  
     *     <blockquote><code>
     *     <i>ClassName</i>.<i>name</i>(int,<i>VarTypeNativeOfField</i>)
     *     </code></blockquote>
     *   </li>
     * </ul>
     * 
     * Where <i>ParamsDec</i> format is the same of {@link #getDeclarationString()},
     * and <i>VarTypeNativeOfField</i> is the variable native type of the field
     * with format explained in {@link NativeVarTypeManager#dec(String,String[])}.
     * 
     * 
     * @param name the used method/field name to construct the string.
     * @return the string representation of the native signature.
     * @see com.innowhere.jnieasy.core.mem.DynamicLibrary#findBehaviorBySignature(String)
     */     
    public String getSignatureString(String name);
    
    /**
     * Returns the parameter declaration at the specified position.
     *
     * @param index zero-based index of parameter to return.
     * @return the parameter at the specified position.
     */
    public VarTypeNative getParameterVarType(int index);
    
    /**
     * Returns the return declaration of the method.
     *
     * @return the variable type declaration of the method return.
     */    
    public VarTypeNative getReturnVarType();
    
    /**
     * Declares a behavior native type using this signature and
     * specified class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decBehavior(methodClass, this);
     * </code></blockquote>
     *
     * @param methodClass the behavior class or interface to use.
     * @return the native type of the declaration.
     */
    public TypeNativeBehavior decBehavior(Class methodClass); 

    /**
     * Creates a native behavior reflection instance using this signature
     * and the specified java.lang.reflect.Member object.
     * <p>
     * The reflection object (Field, Method or Constructor) 
     * describing a Java method/field, must be compatible with the native signature, 
     * the container class of the method/field (if defined) and parameters must be 
     * the same, otherwise an exception is thrown. 
     * <p>
     * This behavior signature defines the native behavior missing 
     * in the reflection object. 
     * <p>
     * The ReturnedReflection returned holds the submitted reflection object.
     * 
     * 
     * 
     * 
     * @param member the reflection object.
     * @return a new <code>NativeBehaviorReflection</code> as a callback of 
     *         the constructor defined in the native signature.
     * @see #newDirectCallback(Member)
     * @see TypeCanBeNativeCapable#wrapValue(Object)
     */
    public NativeBehaviorReflection newBehaviorReflection(Member member);
    
    /**
     * Creates a new direct callback object of the method
     * defined using the specified java.lang.reflect.Member object.
     * <p>
     * The reflection object (Field, Method or Constructor) 
     * describing a Java method, must be compatible with the native signature, 
     * the container class of the method (if defined) and parameters must be 
     * the same, otherwise an exception is thrown. 
     * <p>
     * This behavior signature defines the native behavior missing in 
     * the reflection object.
     * <p>
     * A new Java class is created "on the fly" and loaded on memory using 
     * the current ClassLoader. This object works like NativeBehaviorReflection,
     * exporting a normal Java method as native, but the managed Java method
     * (the method described in <code>member</code>), is called not 
     * using reflection. The new Java class has a name constructed
     * using the Member object info, only the first direct 
     * callback using a Member object creates and loads a new class, 
     * a second instance uses the loaded class and is created without reflection.
     * <p>
     * If the current ClassLoader is not an enhancer ClassLoader, the method
     * ClassLoader.defineClass(String,byte[],int,int) is called using
     * reflection (because this method is protected) previously enabling
     * private/protected calls with Method.setAccessible(true), a 
     * SecurityException is raised if disabling the access checking is forbidden.
     * 
     * 
     * @param member the reflection object.
     * @return a new <code>NativeDirectCallback</code> as a callback of the specified method with <code>member</code>.
     * @see #newBehaviorReflection(Member)
     * @see NativeTypeManager#getClassLoader()
     */
    public NativeDirectCallback newDirectCallback(Member member);
    
    /**
     * Creates and attachs to the specified address and offset of a native method
     * a native instance of a predefined class implementing the interface
     * {@link com.innowhere.jnieasy.core.method.NativeBehavior}
     *
     * With this object the native method can be called from Java using
     * this signature.
     * <p>
     * Depending on this signature type, the returned method may be a 
     * {@link com.innowhere.jnieasy.core.method.NativeConstructor}
     * {@link com.innowhere.jnieasy.core.method.NativeStaticMethod},
     * {@link com.innowhere.jnieasy.core.method.NativeInstanceMethod},
     * {@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethod},
     * {@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod},
     *
     * @param address the main address of the native method
     * @param offset the relative offset of the the main address
     * @return the native instance mapping the specified native method with this signature.
     */
    public NativeBehavior attachBehavior(NativeAddress address,long offset);
    
    /**
     * Creates and attachs to the specified address of a native method
     * a native instance of a predefined class implementing the interface
     * {@link com.innowhere.jnieasy.core.method.NativeBehavior}
     * <p>
     * Current implementation calls {@link #attachBehavior(NativeAddress,long)}
     * with offset set to 0.
     * 
     * 
     * @param address the address of the native method
     * @return the native instance mapping the specified native method with this signature.
     */    
    public NativeBehavior attachBehavior(long address);    
}
