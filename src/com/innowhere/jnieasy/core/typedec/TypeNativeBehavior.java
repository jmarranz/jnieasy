/*
 * TypeNativeBehavior.java
 *
 * Created on 12 de enero de 2005, 17:27
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeBehavior</code> is the interface that represents a native
 * behavior type declaration.
 * <p>
 * Expression syntax if declaring the type using a string with
 * {@link NativeTypeManager#dec(String,String[])} :
 * <p> 
 * <blockquote><code>
 * <i>ClassName</i>[{ <i>Signature</i> }]
 * </code></blockquote>  
 * <p>
 * Where the <code><i>Signature</i></code> syntax is defined in 
 * {@link NativeBehaviorSignature}.
 * <p>
 * The behavior signature may be not specified in user defined direct
 * callbacks (signature declaration is implicit to the class).
 * <p>
 * Spaces may be used as separators when appropriated.
 * <p>
 * Example: "java.lang.reflect.Method {double __stdcall mypkg.MyClass(int,int) }".
 * <p>
 * <code>"java.lang.reflect.Method {double __stdcall mypkg.MyClass(int,int) }"</code>
 * <blockquote>Declares a method callback using reflection Method objects, 
 * the expected signature is instance methods of class mypkg.MyClass with
 * two int parameters returning double. This callbacks must be called using
 * de standard call convention.</blockquote>
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decBehavior(Class,NativeBehaviorSignature)
 * @see com.innowhere.jnieasy.core.method.NativeBehavior
 */

public interface TypeNativeBehavior extends TypeNativeCapable
{
    /**
     * Returns the native signature of the declared behavior.
     *
     * @return the native signature object.
     */    
    public NativeBehaviorSignature getBehaviorSignature();    
}
