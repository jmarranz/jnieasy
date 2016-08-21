/*
 * NativeSeparatedFieldContainerDescriptor.java
 *
 * Created on 13 de octubre de 2005, 19:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeSeparatedFieldContainerDescriptor</code> interface is the base interface
 * of descriptor interfaces of "separated field" containers like C++ classes 
 * and structures.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.data.NativeSeparatedFieldContainer
 */
public interface NativeSeparatedFieldContainerDescriptor extends NativeMultipleFieldContainerDescriptor
{
    
}
