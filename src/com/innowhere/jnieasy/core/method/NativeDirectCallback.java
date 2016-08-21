/*
 * NativeDirectCallback.java
 *
 * Created on 13 de febrero de 2004, 11:12
 */

package com.innowhere.jnieasy.core.method;
import com.innowhere.jnieasy.core.data.*;


/**
 * The <code>NativeDirectCallback</code> is the interface implemented by
 * native capable classes that make accessible Java fields
 * and methods from native seen as methods. Java fields and methods
 * are accessed NOT using Java reflection.
 * <p>
 * A native instance of this type serves as a bridge between the 
 * native world and Java world: native world can access the related
 * method or field calling as a normal native method; this call 
 * is marshalled and converted in a normal Java call/field access NOT
 * using reflection, because a new Java class is created on the fly
 * if necessary with the normal Java code to call/access the method or field.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeBehaviorReflection
 * @see com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature#newDirectCallback(Member)
 */
public interface NativeDirectCallback extends NativeCapable,NativeCallback
{

}

