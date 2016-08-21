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
import com.innowhere.jnieasy.core.method.NativeFieldMethod;
import java.lang.reflect.Field;

/**
 * The <code>NativeFieldMethodDescriptor</code> is the descriptor interface 
 * of user defined native constructors.
 *
 * @author Jose M. Arranz Santamaria
 * @see NativeMultipleFieldContainerDescriptor#getBehaviors()
 * @see NativeMultipleFieldContainerDescriptor#getBehavior(java.lang.reflect.Member)
 */
public interface NativeFieldMethodDescriptor extends NativeBehaviorDescriptor
{
    /**
     * Returns the native field-method object used to make native calls
     * (and receive native calls if it is a callback).
     * <p>
     * If described Java field-method is made visible from native:
     * <ul>
     *   <li>as a proxy of a DLL method: a
     *      {@link com.innowhere.jnieasy.core.method.CFieldMethod} 
     *      object is returned.
     *   <li>as a normal method callable from native: a
     *      {@link com.innowhere.jnieasy.core.method.NativeFieldCallback}
     *      object is returned. This object may be a 
     *      {@link com.innowhere.jnieasy.core.method.NativeFieldMethodReflection} or a
     *      {@link com.innowhere.jnieasy.core.method.NativeDirectFieldCallback}.
     * </ul>
     *
     * @return the native field-method object used to make native the described method.
     * @see #getNativeBehavior()
     */    
    public NativeFieldMethod getNativeFieldMethod();
    
    /**
     * Returns the field reflection object of the field-method.
     *     
     * @return the reflection object.
     */    
    public Field getField();    
}
