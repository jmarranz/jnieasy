/*
 * NativeMethod.java
 *
 * Created on 1 de abril de 2005, 13:40
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;

/**
 * The <code>NativeFieldMethod</code> is the interface implemented by
 * native capable classes that bridges Java and native fields seen as methods.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeFieldMethod extends NativeBehavior
{
    /**
     * Constant used to get the field value calling methods of 
     * native field-method instances.
     */
    public int GET = 0;
    
    /**
     * Constant used to set a new value to the field calling methods of 
     * native field-method instances.
     */    
    public int SET = 1; 
    
    /**
     * Constant used to get the current value and update with a new value the field calling methods of 
     * native field-method instances.
     */        
    public int GET_SET = 2; 
    
    /**
     * Returns the native signature of the field-method instance.
     *
     * @return the native signature object.
     */      
    public NativeFieldMethodSignature getFieldMethodSignature();    
}
