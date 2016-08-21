/*
 * NativeBehaviorDescriptor.java
 *
 * Created on 24 de junio de 2005, 18:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import com.innowhere.jnieasy.core.method.NativeBehavior;

/**
 * The <code>NativeBehaviorDescriptor</code> interface is the base interface
 * of descriptor interfaces of Java methods and field-methods declared as native.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeMultipleFieldContainerDescriptor#getBehaviors()
 * @see NativeMultipleFieldContainerDescriptor#getBehavior(java.lang.reflect.Member)
 */

public interface NativeBehaviorDescriptor extends NativeMemberDescriptor
{
    /**
     * Returns the native object instance used to make native calls
     * (and receive native calls if it is a callback).
     * <p>
     * If described Java method is made visible from native:
     * <ul>
     *   <li>as a proxy of a DLL method: a
     *      {@link com.innowhere.jnieasy.core.method.DLLBehavior} 
     *      object is returned.
     *   <li>as a normal method callable from native: a
     *      {@link com.innowhere.jnieasy.core.method.NativeCallback}
     *      object is returned. This object may be a 
     *      {@link com.innowhere.jnieasy.core.method.NativeBehaviorReflection}
     *      or a {@link com.innowhere.jnieasy.core.method.NativeDirectCallback}.
     * </ul>
     *     
     * @return the native object used to make native the described method.
     */
    public NativeBehavior getNativeBehavior();
}
