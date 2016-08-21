/*
 * NativeInstanceFieldCallback.java
 *
 * Created on 12 de febrero de 2004, 20:10
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeInstanceFieldCallback</code> is the interface implemented by
 * native capable classes that make accessible Java instance fields
 * from native seen as methods. Java fields 
 * are accessed using Java reflection or normal access.
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeInstanceFieldCallback extends NativeFieldCallback,NativeInstanceFieldMethod
{
    /**
     * Method called after marshalling to Java the native call.
     * 
     * 
     * 
     * 
     * @param obj the native capable object containing the field.
     * @param opcode the operation code used.
     * @param value the new value used to update the field.
     * @return the current value of the field when reading or any value if writing.
     * @see NativeInstanceFieldMethod#call(Object,int,Object)
     * @see NativeConstructorCallback#onCall(Object[])
     */    
    public Object onCall(Object obj,int opcode,Object value);     
}
