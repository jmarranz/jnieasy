/*
 * NativePointer.java
 *
 * Created on 23 de septiembre de 2005, 17:41
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativePointer</code> is the interface implemented by 
 * native capable classes wrapping a native object reference working 
 * as a native pointer.
 * <p>
 * NativePointer based classes may be user defined classes, exists a default 
 * class of the framework implementing this interface.
 * <p>
 * The Object field contained must be declared as an Object derived 
 * variable native type "by pointer".
 * <p>
 * A reference to a native instance of a class implementing NativePointer 
 * may be seen as a "pointer to pointer", because the instance represents
 * itself a pointer to the addressed instance by the pointer field.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativePointer extends NativeObjectFieldContainer
{
}
