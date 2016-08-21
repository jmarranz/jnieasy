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
 * The <code>NativeDirectStaticFieldCallbackDescriptor</code> interface is the descriptor 
 * of direct static field callback native classes.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback
 */

public interface NativeDirectStaticFieldCallbackDescriptor extends NativeDirectFieldCallbackDescriptor
{
    /**
     * Returns the static native field-method signature defined in the native class.
     *
     * @return the native signature object.
     */             
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature();
}
