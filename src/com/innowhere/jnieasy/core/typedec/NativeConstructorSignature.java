/*
 * NativeConstructorSignature.java
 *
 * Created on 11 de febrero de 2004, 21:12
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeConstructorReflection;
import com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback;
import java.lang.reflect.Constructor;

/**
 * The <code>NativeConstructorSignature</code> interface represents
 * the native signature declaration of native constructors. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decConstructor(Class,Object[],int)
 */

public interface NativeConstructorSignature extends NativeBehaviorSignature
{
    /**
     * Returns the native Class containing the constructor. 
     *
     * @return the native class of the constructor.
     */
    public Class getThisClass();
   
    /**
     * Declares a constructor native type using the specified 
     * native constructor class and this signature.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decConstructor(methodClass,this);
     * </code></blockquote>
     * 
     * 
     * @param methodClass the native constructor class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decConstructor(Class,NativeConstructorSignature)
     * @see #decBehavior(Class)
     */     
    public TypeNativeConstructor decConstructor(Class methodClass);
    
    /**
     * Returns the constructor reflection object with
     * the information defined in this signature.
     * <p>
     * If there is no Java constructor an exception is thrown.
     * 
     * @return the java.lang.reflect.Constructor object.
     */
    public Constructor getConstructor();  
    
    /**
     * Creates a native constructor reflection wrapper using this signature
     * and the constructor reflection object returned by {@link #getConstructor()}
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the returned Constructor of {@link #getConstructor()}.
     * 
     * 
     * @return a new <code>NativeConstructorReflection</code> object as a 
     *         callback of the constructor defined in the native signature.
     */
    public NativeConstructorReflection newConstructorReflection();
    
    /**
     * Creates a new direct constructor callback of the constructor
     * defined with this signature.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the returned Constructor of {@link #getConstructor()}.
     * 
     * @return a new <code>NativeDirectConstructorCallback</code> as a 
     *         callback of the constructor defined in the native signature.
     */
    public NativeDirectConstructorCallback newDirectConstructorCallback();
    
}
