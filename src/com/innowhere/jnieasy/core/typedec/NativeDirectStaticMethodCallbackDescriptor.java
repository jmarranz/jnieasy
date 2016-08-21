/*
 * NativeDirectStaticMethodCallbackDescriptor.java
 *
 * Created on 7 de julio de 2005, 20:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;


/**
 * The <code>NativeDirectStaticMethodCallbackDescriptor</code> interface is the descriptor 
 * of direct static method callback native classes.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback
 */

public interface NativeDirectStaticMethodCallbackDescriptor extends NativeDirectMethodCallbackDescriptor
{
    /**
     * Returns the native static method signature defined in the native class.
     *
     * @return the native signature object.
     */        
    public NativeStaticMethodSignature getStaticMethodSignature();
}
