/*
 * NativeMemberReflection.java
 *
 * Created on 1 de diciembre de 2004, 17:44
 */

package com.innowhere.jnieasy.core.data;

import java.lang.reflect.Member;

/**
 * The <code>NativeMemberReflection</code> is the interface implemented by
 * native capable classes that make accessible fields
 * and methods from native using Java reflection.
 * <p>
 * A native instance of this type contains (or must contain) 
 * a reflection object.
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeMemberReflection extends CanBeNativeCapable
{
    /**
     * Returns the internal java.lang.reflect.Member. Native memory is 
     * in no way read.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (Member)getValue();
     * </code></blockquote>
     *
     * @return the internal Member object.
     * @see NativeSingleFieldContainer#getValue()
     */          
    public Member getMember();
    
    /**
     * Sets the internal java.lang.reflect.Member object. Native memory is 
     * in no way updated.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * setValue(value);
     * </code></blockquote>
     *
     * @param value the new value. Can not be null.
     * @see NativeSingleFieldContainer#setValue(Object)
     */    
    public void setMember(Member value);    
}
