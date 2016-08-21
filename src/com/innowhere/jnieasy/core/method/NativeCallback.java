/*
 * NativeCallback.java
 *
 * Created on 13 de febrero de 2004, 11:12
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeCallback</code> is the interface implemented by
 * native capable classes that bridges Java and native methods and fields (as methods).
 *
 * A native instance serves as a bridge between the 
 * native world and Java world: native world can call the Java method/field-method 
 * wrapped as a normal native method; this call is marshalled and
 * converted in a Java call/field access using reflection or a normal Java method
 * call or access.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeCallback extends NativeBehavior
{

}

