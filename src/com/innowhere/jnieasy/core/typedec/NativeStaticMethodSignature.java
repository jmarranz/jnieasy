/*
 * NativeStaticMethodSignature.java
 *
 * Created on 25 de febrero de 2004, 19:25
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback;
import com.innowhere.jnieasy.core.method.NativeStaticMethodReflection;
import java.lang.reflect.Method;

/**
 * The <code>NativeStaticMethodSignature</code> interface represents
 * the native signature declaration of static native methods. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decStaticMethod(Object,Object[],int)
 */

public interface NativeStaticMethodSignature extends NativeMethodSignature
{
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
    public Method getMethod(Class clasz,String methodName);
    
    /**
     * Declares a native static method type using the specified 
     * method class and this signature.
     * <p>   
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decStaticMethod(methodClass,this);
     * </code></blockquote>
     * 
     * 
     * @param methodClass the native method class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decStaticMethod(Class,NativeStaticMethodSignature)
     * @see #decBehavior(Class)
     */            
    public TypeNativeStaticMethod decStaticMethod(Class methodClass);    
    
    /**
     * Creates a native static method reflection wrapper using this signature
     * and the specified container class and method name.
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the method returned by {@link #getMethod(Class,String)} using the specified class and method name.
     * 
     * 
     * @param containerClass the container class of the method.
     * @param methodName the method name to find.
     * @return a new <code>NativeStaticMethodReflection</code> object as a callback of the specified method.
     */    
    public NativeStaticMethodReflection newStaticMethodReflection(Class containerClass,String methodName);
    
    /**
     * Creates a new direct static method callback of the Java method
     * using this signature and the specified container class and method name.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the method returned by {@link #getMethod(Class,String)} using the specified class and method name.
     * 
     * 
     * @param containerClass the container class of the method.
     * @param methodName the method name to find.
     * @return a new <code>NativeDirectStaticMethodCallback</code> as a callback of the specified method.
     */           
    public NativeDirectStaticMethodCallback newDirectStaticMethodCallback(Class containerClass,String methodName);    
}
