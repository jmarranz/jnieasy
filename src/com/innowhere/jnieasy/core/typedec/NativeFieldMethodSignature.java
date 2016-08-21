/*
 * NativeFieldMethodSignature.java
 *
 * Created on 16 de julio de 2005, 16:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.NativeFieldMethodReflection;
import com.innowhere.jnieasy.core.method.NativeDirectFieldCallback;
import java.lang.reflect.Field;

/**
 * The <code>NativeFieldMethodSignature</code> interface represents
 * the native signature declaration of native field-methods. 
 * 
 * A field-method signature is the native signature of a special native method
 * oriented to get and set values of a field. This field
 * may be a Java field (static or instance) or a DLL exported C field 
 * (only static).
 * <p>
 * The Java signature (and analogous in C) is:
 * <blockquote><code>
 * public [static] <i>FieldType</i> <i>fieldName</i>(int opcode,<i>FieldType</i> value)
 * </code></blockquote>
 * The <code>opcode</code> is the operation code, GET, SET, or GET_SET as
 * defined in {@link com.innowhere.jnieasy.core.method.NativeFieldMethod}
 * <p>
 * The native declaration of <code>value</code> parameter is identical 
 * to return type.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeSignatureManager#decFieldMethod(Class,Object,int)
 */

public interface NativeFieldMethodSignature extends NativeBehaviorSignature
{
    /**
     * Returns the native type of the <code>value</code> parameter or return.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return getReturnVarType();
     * </code></blockquote>
     *
     * @return the native type of <code>value</code> parameter or return.
     * @see #getReturnVarType()
     */
    public VarTypeNative getFieldVarType();

    /**
     * Declares a native field-method type using the specified 
     * native field class and this signature.
     * <p>    
     * Current implementation is:
     * <blockquote><code>
     * return getTypeManager().decFieldMethod(fieldClass,this);
     * </code></blockquote>
     * 
     * 
     * @param fieldClass the native field class or interface to use.
     * @return the native type of the declaration.
     * @see NativeTypeManager#decFieldMethod(Class,NativeFieldMethodSignature)
     * @see #decBehavior(Class)
     */    
    public TypeNativeFieldMethod decFieldMethod(Class fieldClass);

    /**
     * Creates a native field reflection wrapper using this signature
     * and the specified field reflection object.
     * <p>
     * It is implemented calling {@link #newBehaviorReflection(Member)}
     * with the specified field.
     * 
     * 
     * 
     * @return a new <code>NativeFieldMethodReflection</code> object as a callback of the specified field.
     */    
    public NativeFieldMethodReflection newFieldMethodReflection(Field field);
    
    /**
     * Creates a new direct field callback of the field
     * defined using the specified java.lang.reflect.Field object.
     * <p>
     * It is implemented calling {@link #newDirectCallback(Member)}
     * with the specified field object.
     * 
     * 
     * @return a new <code>NativeDirectFieldCallback</code> as a callback of 
     *         the field defined in the native signature.
     */
    public NativeDirectFieldCallback newDirectFieldCallback(Field field);     
}
