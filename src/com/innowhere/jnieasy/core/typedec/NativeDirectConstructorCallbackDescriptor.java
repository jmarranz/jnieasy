/*
 * NativeDirectConstructorCallbackDescriptor.java
 *
 * Created on 7 de julio de 2005, 20:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeDirectConstructorCallbackDescriptor</code> interface is the descriptor 
 * of direct constructor callback native classes.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 * @see com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback
 */

public interface NativeDirectConstructorCallbackDescriptor extends NativeDirectCallbackDescriptor
{
    /**
     * Returns the native constructor signature defined in the native class.
     *
     * @return the native signature object.
     */    
    public NativeConstructorSignature getConstructorSignature();    
}
