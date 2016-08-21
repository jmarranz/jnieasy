/*
 * NativeInstanceFieldMethod.java
 *
 * Created on 12 de febrero de 2004, 20:41
 */

package com.innowhere.jnieasy.core.method;

import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>NativeInstanceFieldMethod</code> is the interface implemented by
 * native capable classes that bridges Java and native instance fields seen as methods.
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeInstanceFieldMethod extends NativeFieldMethod
{
    /**
     * Returns the native signature of the instance field-method object.
     *
     * @return the native signature object.
     */      
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature();
    
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
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     */    
    public Object call(Object obj,int opcode,Object value);
    
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
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     */    
    public boolean callBoolean(Object obj,int opcode,boolean value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native byte field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */        
    public byte callByte(Object obj,int opcode,byte value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native char field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */     
    public char callChar(Object obj,int opcode,char value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native short field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */    
    public short callShort(Object obj,int opcode,short value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native int field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */    
    public int callInt(Object obj,int opcode,int value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native long field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */    
    public long callLong(Object obj,int opcode,long value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native float field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */    
    public float callFloat(Object obj,int opcode,float value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native double field.
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */    
    public double callDouble(Object obj,int opcode,double value);
    
    /**
     * Calls the native field-method to get/set the value of the related
     * native Object field.
     * <p>
     * The native type of the field must be an Object derived type: a "can be native"
     * or a native capable class/interface. 
     *
     * @param obj the native capable object containing the field.
     * @param opcode the operation code over the field.
     * @param value the new value when updating or any valid value.
     * @return the current value of the field when reading or any value if writing.
     * @see #callBoolean(Object,int,boolean)
     */    
    public Object callObject(Object obj,int opcode,Object value);
    
    /**
     * Updates the native field with the specified value.
     * <p>
     * The specified value must match the native type of the field. 
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * call(obj,SET,value);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     */    
    public void set(Object obj,Object value);
    
    /**
     * Updates the native field with the specified boolean value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callBoolean(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callBoolean(Object,int,boolean)
     */    
    public void setBoolean(Object obj,boolean value);
    
    /**
     * Updates the native field with the specified byte value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callByte(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callByte(Object,int,byte)
     */    
    public void setByte(Object obj,byte value);
    
    /**
     * Updates the native field with the specified char value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callChar(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callChar(Object,int,char)
     */    
    public void setChar(Object obj,char value);
    
    /**
     * Updates the native field with the specified short value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callShort(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callShort(Object,int,short)
     */    
    public void setShort(Object obj,short value);
    
    /**
     * Updates the native field with the specified int value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callInt(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callInt(Object,int,int)
     */    
    public void setInt(Object obj,int value);
    
    /**
     * Updates the native field with the specified long value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callLong(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callLong(Object,int,long)
     */    
    public void setLong(Object obj,long value);
    
    /**
     * Updates the native field with the specified float value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callFloat(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callFloat(Object,int,float)
     */    
    public void setFloat(Object obj,float value);
    
    /**
     * Updates the native field with the specified double value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * callDouble(obj,SET,value); 
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.
     * @param value the new value.
     * @see #callDouble(Object,int,double)
     */    
    public void setDouble(Object obj,double value);
  
    /**
     * Returns the current native field value.
     * <p>
     * The specified value will match the native type of the field. 
     * <p>
     * Current implementation calls {@link #call(Object,int,Object)} using
     * <code>GET</code> as <code>opcode</code> and as <code>value</code> the default value
     * of the native type wrapped as an Object if necessary 
     * (if native type is int, value passed is new Integer(0)).
     *
     * @param obj the native capable object containing the field.
     * @return the current value of the field.
     */     
    public Object get(Object obj);
    
    /**
     * Returns the current boolean native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callBoolean(obj,GET,false);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callBoolean(Object,int,boolean)
     */       
    public boolean getBoolean(Object obj);
    
    /**
     * Returns the current byte native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callByte(obj,GET,(byte)0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callByte(Object,int,byte)
     */     
    public byte getByte(Object obj);
    
    /**
     * Returns the current char native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callChar(obj,GET,(char)0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callChar(Object,int,char)
     */     
    public char getChar(Object obj);
    
    /**
     * Returns the current short native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callShort(obj,GET,(short)0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callShort(Object,int,short)
     */     
    public short getShort(Object obj);
    
    /**
     * Returns the current int native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callInt(obj,GET,0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callInt(Object,int,int)
     */     
    public int getInt(Object obj);
    
    /**
     * Returns the current long native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callLong(obj,GET,0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callLong(Object,int,long)
     */     
    public long getLong(Object obj);
    
    /**
     * Returns the current float native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callFloat(obj,GET,0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callFloat(Object,int,float)
     */     
    public float getFloat(Object obj);
    
    /**
     * Returns the current double native field value.
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return callDouble(obj,GET,0);
     * </code></blockquote>
     *
     * @param obj the native capable object containing the field.     
     * @return the current value of the field.
     * @see #callDouble(Object,int,double)
     */     
    public double getDouble(Object obj);
    
    /**
     * Sets the native field with the specified value and return the current value before updating.
     * <p>
     * The specified value must match the native type of the field. 
     * <p>
     * Current implementation in the predefined classes implementing this interface is:
     * <blockquote><code>
     * return call(obj,GET_SET,value);
     * </code></blockquote>
     *
     * @param value the new value.
     * @return the current value of the field before updating.
     * @see #call(Object,int,Object)
     */      
    public Object getSet(Object obj,Object value);    
}
