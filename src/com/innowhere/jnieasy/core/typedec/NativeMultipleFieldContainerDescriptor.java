/*
 * NativeMultipleFieldContainerDescriptor.java
 *
 * Created on 24 de junio de 2005, 15:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

import java.lang.reflect.Member;

/**
 * The <code>NativeMultipleFieldContainerDescriptor</code> interface is the base interface
 * of descriptor interfaces of unions and "separated field" containers like C++ classes 
 * and structures.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.data.NativeMultipleFieldContainer
 */

public interface NativeMultipleFieldContainerDescriptor extends NativeFieldContainerDescriptor
{
    /**
     * Returns the descriptor of the base class/structure 
     * or null if there is none.
     * <p>
     * If this descriptor is a union always returns null.
     * 
     * 
     * @return the base <code>NativeSeparatedFieldContainerDescriptor</code> object or null.
     */
    public NativeSeparatedFieldContainerDescriptor getSuper();
    
    /**
     * Returns a descriptor array of the native fields.
     * <p>
     * Changes in this array have no effect.
     *
     * @return the field descriptor array.
     */
    public NativeFieldDescriptor[] getFields();
    
    /**
     * Returns the descriptor of the specified native field.
     * <p>
     * 
     * @param index the zero-based index of the native field.
     * @return the descriptor object of the field.
     */    
    public NativeFieldDescriptor getField(int index);
    
    /**
     * Returns the number of native fields.
     *
     * @return the number of native fields.
     */
    public int getFieldCount();    
    
    /**
     * Returns the descriptor of the specified native field
     * of this container or any super container.
     * <p>
     * The parameter <code>index</code> is the zero-based 
     * absolute field index of all native fields defined in the 
     * container tree.
     *
     * @param index the zero-based index of the native field.
     * @return the descriptor object of the field.
     */
    public NativeFieldDescriptor getAbsoluteField(int index);
    
    /**
     * Returns the number of native fields of this container 
     * and super containers.
     *
     * @return the number of native fields.
     */    
    public int getAbsoluteFieldCount();    
    
    /**
     * Returns the descriptor of the native field of this container 
     * with the specified name.
     * <p>
     * 
     * @param fieldName the name of the native field to find.
     * @return the descriptor object of the field.
     */        
    public NativeFieldDescriptor getField(String fieldName); 
    
    /**
     * Returns a descriptor array of the native methods.
     * <p>
     * Changes in this array have no effect.
     *
     * @return the method descriptor array.
     */    
    public NativeBehaviorDescriptor[] getBehaviors();
    
    /**
     * Returns the descriptor of the native method of this container 
     * with the specified reflection object.
     * <p>
     * 
     * @param member the reflection object of the native method to find.
     * @return the descriptor object of the method.
     */        
    public NativeBehaviorDescriptor getBehavior(Member member);    
}
