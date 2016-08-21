/*
 * NativeConstructorDescriptor.java
 *
 * Created on 24 de junio de 2005, 18:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.method.NativeConstructor;
import java.lang.reflect.Constructor;

/**
 * The <code>NativeConstructorDescriptor</code> is the descriptor interface 
 * of user defined native constructors.
 *
 * @author Jose M. Arranz Santamaria
 * @see NativeMultipleFieldContainerDescriptor#getBehaviors()
 * @see NativeMultipleFieldContainerDescriptor#getBehavior(java.lang.reflect.Member)
 */
public interface NativeConstructorDescriptor extends NativeBehaviorDescriptor
{
    /**
     * Returns the native constructor object used to make native calls
     * (and receive native calls if it is a callback).
     * <p>
     * If described Java constructor is made visible from native:
     * <ul>
     *   <li>as a proxy of a DLL method: a
     *      {@link com.innowhere.jnieasy.core.method.CPPConstructor} 
     *      object is returned.
     *   <li>as a normal method callable from native: a
     *      {@link com.innowhere.jnieasy.core.method.NativeConstructorCallback}
     *      object is returned. This object may be a 
     *      {@link com.innowhere.jnieasy.core.method.NativeConstructorReflection} or a
     *      {@link com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback}.
     * </ul>
     *
     * @return the native constructor object used to make native the described method.
     * @see #getNativeBehavior()
     */
    public NativeConstructor getNativeConstructor();  
    
    /**
     * Returns the constructor reflection object of the field or method.
     *     
     * @return the reflection object.
     */
    public Constructor getConstructor();  
}
