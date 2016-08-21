/*
 * NativeObjectFieldContainerDescriptor.java
 *
 * Created on 29 de septiembre de 2005, 14:30
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeObjectFieldContainerDescriptor</code> interface is the base interface
 * of descriptor interfaces of one and only native field user defined classes. 
 * This one native field is ever an object because any other case is covered
 * with predefined native types of the framework.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.data.NativeObjectFieldContainer
 */
public interface NativeObjectFieldContainerDescriptor extends NativeFieldContainerDescriptor
{
    /**
     * Returns the descriptor of the native field.
     * 
     * @return the descriptor object of the field.
     */        
    public NativeFieldDescriptor getField();    
}
