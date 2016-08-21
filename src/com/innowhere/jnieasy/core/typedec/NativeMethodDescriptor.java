/*
 * NativeMethodDescriptor.java
 *
 * Created on 24 de junio de 2005, 18:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.method.NativeMethod;
import java.lang.reflect.Method;

/**
 * The <code>NativeMethodDescriptor</code> interface is the base interface
 * of descriptor interfaces of Java methods declared as native.
 *
 * @author Jose M. Arranz Santamaria
 */
public interface NativeMethodDescriptor extends NativeBehaviorDescriptor
{
    /**
     * Returns the native method object used to make native calls
     * (and receive native calls if it is a callback).
     * <p>
     * If described Java method is made visible from native:
     * <ul>
     *   <li>as a proxy of a DLL method: a
     *      {@link com.innowhere.jnieasy.core.method.DLLMethod} 
     *      object is returned.
     *   <li>as a normal method callable from native: a
     *      {@link com.innowhere.jnieasy.core.method.NativeMethodCallback}
     *      object is returned. This object may be a 
     *      {@link com.innowhere.jnieasy.core.method.NativeMethodReflection} or a
     *      {@link com.innowhere.jnieasy.core.method.NativeDirectMethodCallback}.
     * </ul>
     *
     * @return the native method object used to make native the described method.
     * @see #getNativeBehavior()
     */        
    public NativeMethod getNativeMethod();

    /**
     * Returns the method reflection object of the method.
     *     
     * @return the reflection object.
     */        
    public Method getMethod();    
}
