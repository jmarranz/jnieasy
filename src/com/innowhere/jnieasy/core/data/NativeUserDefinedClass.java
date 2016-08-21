/*
 * NativeUserDefinedClass.java
 *
 * Created on 24 de junio de 2005, 17:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.data;

import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;

/**
 * The <code>NativeUserDefinedClass</code> is the interface implemented by 
 * all user defined native capable classes.
 * <p>
 * This interface is defined to identification purposes and
 * to get the native class descriptor.
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeUserDefinedClass
{
    /**
     * Returns the native class descriptor of the user defined native
     * class of the instance.
     *
     * @return the native class descriptor object.
     */
    public NativeClassDescriptor jnieasyGetNativeClassDescriptor();
}
