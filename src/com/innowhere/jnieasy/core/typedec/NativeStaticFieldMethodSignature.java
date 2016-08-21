/*
 * NativeStaticFieldMethodSignature.java
 *
 * Created on 16 de julio de 2005, 16:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;
import java.lang.reflect.Field;


/**
 * The <code>NativeStaticFieldMethodSignature</code> interface represents
 * the native signature declaration of static native field-methods. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decStaticFieldMethod(Object,int)
 */

public interface NativeStaticFieldMethodSignature extends NativeFieldMethodSignature
{
    /**
     * Returns the field reflection object with the specified field name
     * and container class.
     * <p>
     * If there is no Java field with this name and class or field
     * type is different an exception is thrown.
     *
     * @param containerClass the container class of the field.
     * @param fieldName the field name to find.
     * @return the java.lang.reflect.Field object found.
     */    
    public Field getField(Class containerClass,String fieldName);    
    
    /**
     * Declares a native static field-method type using the specified 
     * native field class and this signature.
     * <p>   
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decStaticFieldMethod(fieldClass,this);
     * </code></blockquote>
     * 
     * 
     * @param fieldClass the native field class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decStaticFieldMethod(Class,NativeStaticFieldMethodSignature)
     * @see #decBehavior(Class)
     */        
    public TypeNativeStaticFieldMethod decStaticFieldMethod(Class fieldClass);      
    
    /**
     * Creates a native static field reflection wrapper using this signature
     * and the specified container class and field name.
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the field returned by {@link #getField(Class,String)} using the specified class and field name.
     * 
     * 
     * 
     * @param containerClass the container class of the field.
     * @param fieldName the field name to find.
     * @return a new <code>NativeStaticFieldMethodReflection</code> object as a callback of the specified field.
     */
    public NativeStaticFieldMethodReflection newStaticFieldMethodReflection(Class containerClass,String fieldName);
    
    /**
     * Creates a new direct static field callback of the Java field
     * using this signature and the specified container class and field name.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the field returned by {@link #getField(Class,String)} using the specified class and field name.
     * 
     * 
     * @param containerClass the container class of the field.
     * @param fieldName the field name to find.
     * @return a new <code>NativeDirectStaticFieldCallback</code> as a callback of the specified field.
     */        
    public NativeDirectStaticFieldCallback newDirectStaticFieldCallback(Class containerClass,String fieldName);
}
