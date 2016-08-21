/*
 * NativeMethodSignature.java
 *
 * Created on 28 de febrero de 2005, 14:22
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeDirectMethodCallback;
import com.innowhere.jnieasy.core.method.NativeMethodReflection;
import java.lang.reflect.Method;

/**
 * The <code>NativeMethodSignature</code> interface represents
 * the native signature declaration of native methods. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decMethod(Class,Object,Object[],int)
 */

public interface NativeMethodSignature extends NativeBehaviorSignature
{
    /**
     * Declares a native method type using the specified 
     * native method class and this signature.
     * <p>    
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decMethod(methodClass,this);
     * </code></blockquote>
     * 
     * 
     * @param methodClass the native method class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decMethod(Class,NativeMethodSignature)
     * @see #decBehavior(Class)
     */        
    public TypeNativeMethod decMethod(Class methodClass);   
    
    /**
     * Creates a native method reflection wrapper using this signature
     * and the specified method reflection object.
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the specified method.
     * 
     * 
     * @return a new <code>NativeMethodReflection</code> object as a callback of the specified method.
     */        
    public NativeMethodReflection newMethodReflection(Method method);
    
    /**
     * Creates a new direct method callback of the method
     * defined using the specified java.lang.reflect.Method object.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the specified method object.
     * 
     * 
     * @return a new <code>NativeDirectMethodCallback</code> as a callback 
     *         of the method defined in the native signature.
     */    
    public NativeDirectMethodCallback newDirectMethodCallback(Method method);    
}
