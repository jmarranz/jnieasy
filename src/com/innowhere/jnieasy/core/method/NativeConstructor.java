/*
 * NativeConstructor.java
 *
 * Created on 12 de febrero de 2004, 20:41
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>NativeConstructor</code> is the interface implemented by
 * native capable classes that bridges Java and native constructors. 
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeConstructor extends NativeBehavior
{
    /**
     * Returns the native signature of the constructor instance.
     *
     * @return the native signature object.
     */          
    public NativeConstructorSignature getConstructorSignature();
    
    /**
     * Calls the native constructor.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * Returned value type will match the native type of the declared class.
     *
     * @param args the arguments passed to the method.
     * @return the new constructed native object.
     */        
    public Object call(Object[] args);  
    
    /**
     * Calls the native constructor using an instance as proxy of the returned address
     * of the created object.
     * <p>
     * The specified arguments must match the native type of the method parameters. 
     * Returned value type will match the native type of the declared class.
     * <p>
     * The <code>proxy</code> argument must be a native capable instance of
     * the class of the constructor. This proxy will be attached to the returned 
     * address of the native constructor call.
     *
     * @param proxy the native capable object used as proxy.
     * @param args the arguments passed to the method.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#attach(Object,long)
     */            
    public void call(Object proxy,Object[] args);    
}
