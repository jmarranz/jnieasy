/*
 * NativeDirectCallbackDescriptor.java
 *
 * Created on 7 de julio de 2005, 20:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeDirectCallbackDescriptor</code> interface is the base interface
 * of descriptor interfaces of direct callback native classes.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.method.NativeDirectCallback
 */

public interface NativeDirectCallbackDescriptor extends NativeClassDescriptor
{
    /**
     * Returns the native signature of the behavior defined in the native class.
     *
     * @return the native signature object.
     */
    public NativeBehaviorSignature getBehaviorSignature();
}
