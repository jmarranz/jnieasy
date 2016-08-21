/*
 * StaticMethodCallback.java
 *
 * Created on 12 de febrero de 2004, 19:46
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeStaticFieldCallback</code> is the interface implemented by
 * native capable classes that make accessible Java static fields
 * from native seen as methods. Java fields 
 * are accessed using Java reflection or normal access.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStaticFieldCallback extends NativeFieldCallback,NativeStaticFieldMethod
{
    /**
     * Method called after marshalling to Java the native call.
     * 
     * 
     * @param opcode the operation code used.
     * @param value the new value used to update the field.
     * @return the current value of the field when reading or any value if writing.
     * @see NativeStaticFieldMethod#call(int,Object)
     * @see NativeConstructorCallback#onCall(Object[])
     */
    public Object onCall(int opcode,Object value);  
}
