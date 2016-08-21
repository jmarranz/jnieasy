/*
 * NativeFieldDescriptor.java
 *
 * Created on 24 de junio de 2005, 18:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import java.lang.reflect.Field;

/**
 * The <code>NativeFieldDescriptor</code> is the descriptor interface 
 * of native fields of user defined native classes.
 *
 * @author Jose M. Arranz Santamaria
 * @see NativeMultipleFieldContainerDescriptor#getFields()
 * @see NativeObjectFieldContainerDescriptor#getField()
 */

public interface NativeFieldDescriptor extends NativeMemberDescriptor
{
    /**
     * Returns the native variable type of this native field.
     *
     * @return the native variable type.
     */
    public VarTypeNative getVarType();
    
    /**
     * Returns the native field name.
     *
     * @return the name of the field.
     */
    public String getName();   
    
    /**
     * Returns the relative position in the container memory 
     * of this native field.
     * 
     * @return the memory offset of the field.
     */
    public long getOffset();
    
    /**
     * Returns the reflection field object of this native field.
     * 
     * @return the reflection object of the field.
     */
    public Field getField();
}
