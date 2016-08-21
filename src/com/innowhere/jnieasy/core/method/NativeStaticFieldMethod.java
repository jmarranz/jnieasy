/*
 * NativeStaticFieldMethod.java
 *
 * Created on 12 de febrero de 2004, 20:40
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>NativeStaticFieldMethod</code> is the interface implemented by
 * native capable classes that bridges Java and native static fields seen as methods.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStaticFieldMethod extends NativeFieldMethod
{
    /**
     * Returns the native signature of the static field-method instance.
     *
     * @return the native signature object.
     */          
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature();
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native field.
     * <p>
     * The specified value must match the native type of the field. 
     * Returned value type will match the native type of the field.
     * <p>
     * If <code>opcode</code> is:
     * <ul>
     *   <li>{@link #GET} : returns the current field value.
     *       The <code>value</code> is ignored, use any valid value of the expected type.
     *   </li>
     *   <li>{@link #SET} : updates the current field value with the specified <code>value</code>.
     *       The returned value must be ignored.
     *   </li>
     *   <li>{@link #GET_SET} : reads the current field value 
     *       before update the field with the specified <code>value</code>.
     *       Returns the current field value before update.
     *   </li>
     * </ul>
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     */    
    public Object call(int opcode,Object value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native boolean field.
     * <p>
     * If <code>opcode</code> is:
     * <ul>
     *   <li>{@link #GET} : returns the current field value.
     *       The <code>value</code> parameter is ignored.
     *   </li>
     *   <li>{@link #SET} : updates the current field value with the specified <code>value</code>.
     *       The returned value must be ignored.
     *   </li>
     *   <li>{@link #GET_SET} : reads the current field value 
     *       before update the field with the specified <code>value</code>.
     *       Returns the current field value before update.
     *   </li>
     * </ul>
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     */     
    public boolean callBoolean(int opcode,boolean value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native byte field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public byte callByte(int opcode,byte value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native char field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public char callChar(int opcode,char value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native short field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public short callShort(int opcode,short value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native int field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public int callInt(int opcode,int value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native long field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public long callLong(int opcode,long value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native float field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public float callFloat(int opcode,float value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native double field.
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public double callDouble(int opcode,double value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native Object field.
     * <p>
     * The native type of the field must be an Object derived type: a "can be native"
     * or a native capable class/interface. 
     *
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(int,boolean)
     */    
    public Object callObject(int opcode,Object value);
        
    /**
     * Updates the native field with the specified value.
     * <p>
     * The specified value must match the native type of the field. 
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * call(SET,value);
     * </code></blockquote>
     *
     * @param value the new value.
     */
    public void set(Object value);
    
    /**
     * Updates the native field with the specified boolean value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callBoolean(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callBoolean(int,boolean)
     */    
    public void setBoolean(boolean value);
    
    /**
     * Updates the native field with the specified byte value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callByte(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callByte(int,byte)
     */    
    public void setByte(byte value);
    
    /**
     * Updates the native field with the specified char value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callChar(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callChar(int,char)
     */    
    public void setChar(char value);
    
    /**
     * Updates the native field with the specified short value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callShort(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callShort(int,short)
     */    
    public void setShort(short value);
    
    /**
     * Updates the native value with the specified int value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callInt(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callInt(int,int)
     */    
    public void setInt(int value);
    
    /**
     * Updates the native field with the specified long value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callLong(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callLong(int,long)
     */    
    public void setLong(long value);
    
    /**
     * Updates the native field with the specified float value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callFloat(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callFloat(int,float)
     */    
    public void setFloat(float value);
    
    /**
     * Updates the native field with the specified double value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callDouble(SET,value); 
     * </code></blockquote>
     *
     * @param value the new value.
     * @see #callDouble(int,double)
     */    
    public void setDouble(double value);
    
    /**
     * Returns the current native field value.
     * <p>
     * The specified value will match the native type of the field. 
     * <p>
     * Current implementation calls {@link #call(int,Object)} using
     * <code>GET</code> as <code>opcode</code> and as <code>value</code> the default value
     * of the native type wrapped as an Object if necessary 
     * (if native type is int, value passed is new Integer(0)).
     *
     * @return the current value of the field.
     */    
    public Object get();
    
    /**
     * Returns the current boolean native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callBoolean(GET,false);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callBoolean(int,boolean)
     */    
    public boolean getBoolean();
    
    /**
     * Returns the current byte native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callByte(GET,(byte)0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callByte(int,byte)
     */    
    public byte getByte();
    
    /**
     * Returns the current char native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callChar(GET,(char)0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callChar(int,char)
     */    
    public char getChar();
    
    /**
     * Returns the current short native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callShort(GET,(short)0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callShort(int,short)
     */    
    public short getShort();
    
    /**
     * Returns the current int native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callInt(GET,0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callInt(int,int)
     */    
    public int getInt();
    
    /**
     * Returns the current long native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callLong(GET,0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callLong(int,long)
     */    
    public long getLong();
    
    /**
     * Returns the current float native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callFloat(GET,0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callFloat(int,float)
     */    
    public float getFloat();
    
    /**
     * Returns the current double native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callDouble(GET,0);
     * </code></blockquote>
     *
     * @return the current value of the field.
     * @see #callDouble(int,double)
     */    
    public double getDouble();
   
    /**
     * Sets the native field with the specified value and return the current value before updating.
     * <p>
     * The specified value must match the native type of the field. 
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return call(GET_SET,value);
     * </code></blockquote>
     *
     * @param value the new value.
     * @return the current value of the field before updating.
     * @see #call(int,Object)
     */  
    public Object getSet(Object value);    
}
