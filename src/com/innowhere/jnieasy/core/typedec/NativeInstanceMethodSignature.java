/*
 * NativeInstanceMethodSignature.java
 *
 * Created on 11 de febrero de 2004, 21:56
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback;
import com.innowhere.jnieasy.core.method.NativeInstanceMethodReflection;
import java.lang.reflect.Method;

/**
 * The <code>NativeInstanceMethodSignature</code> interface represents
 * the native signature declaration of native instance methods. 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decInstanceMethod(Class,Object,Object[],int)
 */

public interface NativeInstanceMethodSignature extends NativeMethodSignature
{
    /**
     * Returns the native Class containing the instance method. 
     *
     * @return the native class of the instance method.
     */
    public Class getThisClass();
    
    /**
     * Returns the method reflection object with the specified method name
     * and container class and parameter types defined in this signature.
     * <p>
     * If there is no Java method with this name, class and parameters or return
     * type is different, an exception is thrown.
     *
     * @param methodName the method name to find.
     * @return the java.lang.reflect.Method object found.
     */    
    public Method getMethod(String methodName);
    
    /**
     * Declares a native instance method type using the specified 
     * native method class and this signature.
     * <p>   
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decInstanceMethod(methodClass,this);
     * </code></blockquote>
     * 
     * @param methodClass the native method class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decInstanceMethod(Class,NativeInstanceMethodSignature)
     * @see #decBehavior(Class)
     */        
    public TypeNativeInstanceMethod decInstanceMethod(Class methodClass);
    
    /**
     * Creates a native instance method reflection wrapper using this signature
     * and the specified method name.
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the method returned by {@link #getMethod(String)} using the specified method name.
     * 
     * 
     * 
     * 
     * @param methodName the method name to find.
     * @return a new <code>NativeInstanceMethodReflection</code> object as a callback of the specified method.
     */    
    public NativeInstanceMethodReflection newInstanceMethodReflection(String methodName);    
    
    /**
     * Creates a new direct instance method callback of the Java method
     * using this signature and the specified method name.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the method returned by {@link #getMethod(String)} using the specified method name.
     * 
     * 
     * 
     * 
     * @param methodName the method name to find.
     * @return a new <code>NativeDirectInstanceMethodCallback</code> as a callback of the specified method.
     */       
    public NativeDirectInstanceMethodCallback newDirectInstanceMethodCallback(String methodName);
}
