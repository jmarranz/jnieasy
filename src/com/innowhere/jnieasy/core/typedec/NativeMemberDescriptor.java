/*
 * NativeMemberDescriptor.java
 *
 * Created on 24 de junio de 2005, 18:34
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;
import java.lang.reflect.Member;

/**
 * The <code>NativeMemberDescriptor</code> interface is the base interface
 * of descriptor interfaces of Java fields and methods declared as native.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 */

public interface NativeMemberDescriptor
{
    /**
     * Returns the reflection object of the field or method.
     *     
     * @return the reflection object.
     */
    public Member getMember();
}
