/*
 * NativeInstanceFieldMethodSignature.java
 *
 * Created on 16 de julio de 2005, 16:18
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback;
import java.lang.reflect.Field;


/**
 * The <code>NativeInstanceFieldMethodSignature</code> interface represents
 * the native signature declaration of native instance field-methods. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decInstanceFieldMethod(Class,Object,int)
 */

public interface NativeInstanceFieldMethodSignature extends NativeFieldMethodSignature
{
    /**
     * Returns the native Class containing the instance field. 
     *
     * @return the native class of the instance field.
     */    
    public Class getThisClass();
    
    /**
     * Returns the field reflection object with the specified field name
     * and container class defined in this signature.
     * <p>
     * If there is no Java field with this name and class or field
     * type is different an exception is thrown.
     *
     * @param fieldName the field name to find.
     * @return the java.lang.reflect.Field object found.
     */
    public Field getField(String fieldName);    
    
    /**
     * Declares a native instance field-method type using the specified 
     * native field class and this signature.
     * <p>   
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decInstanceFieldMethod(fieldClass,this);
     * </code></blockquote>
     * 
     * @param fieldClass the native field class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decInstanceFieldMethod(Class,NativeInstanceFieldMethodSignature)
     * @see #decBehavior(Class)
     */    
    public TypeNativeInstanceFieldMethod decInstanceFieldMethod(Class fieldClass);
    
    /**
     * Creates a native instance field reflection wrapper using this signature
     * and the specified field name.
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the field returned by {@link #getField(String)} using the specified field name.
     * 
     * 
     * 
     * 
     * 
     * @param fieldName the field name to find.
     * @return a new <code>NativeInstanceFieldMethodReflection</code> object as a callback of the specified field.
     */          
    public NativeInstanceFieldMethodReflection newInstanceFieldMethodReflection(String fieldName);
    
    /**
     * Creates a new direct instance field callback of the Java field
     * using this signature and the specified field name.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the field returned by {@link #getField(String)} using the specified field name.
     * 
     * @param fieldName the field name to find.
     * @return a new <code>NativeDirectInstanceFieldCallback</code> as a callback of the specified field.
     */    
    public NativeDirectInstanceFieldCallback newDirectInstanceFieldCallback(String fieldName);      
}
