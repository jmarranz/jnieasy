/*
 * NativeBehaviorReflection.java
 *
 * Created on 1 de diciembre de 2004, 17:45
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.data.NativeMemberReflection;
/**
 * The <code>NativeBehaviorReflection</code> is the interface implemented by
 * native capable classes that make accessible Java fields
 * and methods from native seen as methods. Java fields and methods
 * are accessed using Java reflection.
 * <p>
 * A native instance of this type contains (or must contain) 
 * a reflection object, it serves as a bridge between the 
 * native world and Java world: native world can access this object 
 * calling as a normal native method; this call is marshalled and
 * converted in a Java call/field access using reflection.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeDirectCallback
 * @see com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature#newBehaviorReflection(Member)
 */
public interface NativeBehaviorReflection extends NativeMemberReflection, NativeCallback
{
}

