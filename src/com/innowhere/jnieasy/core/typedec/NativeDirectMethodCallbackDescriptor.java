/*
 * NativeDirectMethodCallbackDescriptor.java
 *
 * Created on 7 de julio de 2005, 20:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;


/**
 * The <code>NativeDirectMethodCallbackDescriptor</code> interface is the base interface
 * of descriptor interfaces of direct method callback native classes.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.method.NativeDirectMethodCallback
 */
public interface NativeDirectMethodCallbackDescriptor extends NativeDirectCallbackDescriptor
{
    /**
     * Returns the native method signature defined in the native class.
     *
     * @return the native signature object.
     */      
    public NativeMethodSignature getMethodSignature();    
}
