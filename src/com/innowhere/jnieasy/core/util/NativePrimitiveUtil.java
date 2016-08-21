/*
 * NativePrimitiveUtil.java
 *
 * Created on 22 de agosto de 2005, 18:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.util;

import com.innowhere.jnieasy.core.JNIEasyException;

/**
 * The <code>NativePrimitiveUtil</code> is a utility class 
 * used to safe conversion between primitive types.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public class NativePrimitiveUtil
{
    /**
     * Copies a byte value to short ignoring the sign.
     * <p>
     * The returned value is ever positive.
     * <p>
     * It is useful to work with 1 byte unsigned values.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (short) (((short)value) & ((short)0x00FF));
     * </code></blockquote>
     *
     * @param value the byte value to convert.
     * @return the unsigned short value. 
     * @see #toSigned(short)
     */
    public static short toUnsigned(byte value)
    {
        return (short) (((short)value) & ((short)0x00FF));
    }    

    /**
     * Secure downcast of a positive short value to byte.
     * <p>
     * It is useful to convert an unsigned short value using 
     * only the lower byte of the data.
     * <p>
     * Current implementation makes a simple "(byte)value" cast,
     * previously checks and throws an exception if 
     * (value & 0xFF00) != 0) is true. 
     * <p>
     * The comparison: <code>(toSigned(toUnsigned(value)) == value)</code>
     * is ever true.
     *
     * @param value the short value to convert.
     * @return the converted byte value. 
     * @see #toUnsigned(byte)
     */    
    public static byte toSigned(short value)
    {
        if ((value & 0xFF00) != 0) throw new JNIEasyException("Data lost: " + value);
        return (byte)value;
    }
    
    /**
     * Copies a short value to int ignoring the sign.
     * <p>
     * The returned value is ever positive.
     * <p>
     * It is useful to work with 2 byte unsigned values.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return ((int)value) & 0x0000FFFF;
     * </code></blockquote>
     *
     * @param value the short value to convert.
     * @return the unsigned int value. 
     * @see #toSigned(int)
     */    
    public static int toUnsigned(short value)
    {
        return ((int)value) & 0x0000FFFF;
    }
    
    /**
     * Secure downcast of a positive int value to short.
     * <p>
     * It is useful to convert an unsigned int value using 
     * only the lower 2 byte of the data.
     * <p>
     * Current implementation makes a simple "(short)value" cast,
     * previously checks and throws an exception if 
     * (value & 0xFFFF0000) != 0) is true.
     * <p>
     * The comparison: <code>(toSigned(toUnsigned(value)) == value)</code>
     * is ever true.
     *
     * @param value the int value to convert.
     * @return the converted short value. 
     * @see #toUnsigned(short)
     */    
    public static short toSigned(int value)
    {
        if ((value & 0xFFFF0000) != 0) throw new JNIEasyException("Data lost: " + value);
        return (short)value;
    }    
    
    /**
     * Copies an int value to long ignoring the sign.
     * <p>
     * The returned value is ever positive.
     * <p>
     * It is useful to work with 4 byte unsigned values.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return ((long)value) & 0x00000000FFFFFFFFL;
     * </code></blockquote>
     *
     * @param value the int value to convert.
     * @return the unsigned long value.
     * @see #toSigned(long) 
     */    
    public static long toUnsigned(int value)
    {
        return ((long)value) & 0x00000000FFFFFFFFL;
    }    
        
    /**
     * Secure downcast of a positive long value to int.
     * <p>
     * It is useful to convert an unsigned long value using 
     * only the lower 4 byte of the data.
     * <p>
     * Current implementation makes a simple "(int)value" cast,
     * previously checks and throws an exception if 
     * (value & 0xFFFFFFFF00000000L) != 0) is true.
     * <p>
     * The comparison: <code>(toSigned(toUnsigned(value)) == value)</code>
     * is ever true.
     *
     * @param value the long value to convert.
     * @return the converted int value.
     * @see #toUnsigned(int) 
     */        
    public static int toSigned(long value)
    {
        if ((value & 0xFFFFFFFF00000000L) != 0) throw new JNIEasyException("Data lost: " + value);
        return (int)value;
    }    
    
    /**
     * Convert a byte array to a short array ignoring the sign.
     * <p>
     * The element conversions is realized using {@link #toUnsigned(byte)}
     *
     * @param array the byte array value to convert.
     * @return the unsigned short array.
     * @see #toSigned(short[])
     */               
    public static short[] toUnsigned(byte[] array)
    {
        short[] arrayRes = new short[array.length];
        for(int i = 0; i < array.length; i++)
            arrayRes[i] = toUnsigned(array[i]); 
        return arrayRes;
    }    
    
    /**
     * Downcasts a short array to a byte array ignoring the sign.     
     * <p>
     * The element conversions is realized using {@link #toSigned(short)}
     *
     * @param array the short array value to convert.
     * @return the converted byte array value. 
     * @see #toUnsigned(byte[]) 
     */    
    public static byte[] toSigned(short[] array)
    {
        byte[] arrayRes = new byte[array.length];
        for(int i = 0; i < array.length; i++)
            arrayRes[i] = toSigned(array[i]); 
        return arrayRes;
    }     
    
    /**
     * Convert a short array to an int array ignoring the sign.
     * <p>
     * The element conversions is realized using {@link #toUnsigned(short)}
     *
     * @param array the short array value to convert.
     * @return the unsigned int array.
     * @see #toSigned(int[])
     */    
    public static int[] toUnsigned(short[] array)
    {
        int[] arrayRes = new int[array.length];
        for(int i = 0; i < array.length; i++)
            arrayRes[i] = toUnsigned(array[i]); 
        return arrayRes;
    }
    
    /**
     * Downcasts an int array to a short array ignoring the sign.     
     * <p>
     * The element conversions is realized using {@link #toSigned(int)}
     *
     * @param array the int array value to convert.
     * @return the converted short array value. 
     * @see #toUnsigned(short[]) 
     */     
    public static short[] toSigned(int[] array)
    {
        short[] arrayRes = new short[array.length];
        for(int i = 0; i < array.length; i++)
            arrayRes[i] = toSigned(array[i]); 
        return arrayRes;
    }         
    
    /**
     * Convert an int array to a long array ignoring the sign.
     * <p>
     * The element conversions is realized using {@link #toUnsigned(int)}
     *
     * @param array the int array value to convert.
     * @return the unsigned long array.
     * @see #toSigned(long[])
     */      
    public static long[] toUnsigned(int[] array)
    {
        long[] arrayRes = new long[array.length];
        for(int i = 0; i < array.length; i++)
            arrayRes[i] = toUnsigned(array[i]); 
        return arrayRes;
    }        
    
    /**
     * Downcasts a long array to an int array ignoring the sign.     
     * <p>
     * The element conversions is realized using {@link #toSigned(long)}
     *
     * @param array the long array value to convert.
     * @return the converted int array value. 
     * @see #toUnsigned(int[]) 
     */     
    public static int[] toSigned(long[] array)
    {
        int[] arrayRes = new int[array.length];
        for(int i = 0; i < array.length; i++)
            arrayRes[i] = toSigned(array[i]); 
        return arrayRes;
    }         
    
    /**
     * Convert a zero-ended string defined as a byte array 
     * in a String object.
     *
     * @param array the byte array value to convert.
     * @return the converted String. 
     * @see #toString(char[]) 
     */     
    public static String toString(byte[] array)
    {
        StringBuffer res = new StringBuffer(array.length);
        for(int i = 0; i < array.length; i++)
        {
            byte c = array[i];
            if (c == 0) break;
            res.append((char)c);
        }
        return res.toString();
    }   
    
    /**
     * Convert a zero-ended string defined as a char array 
     * in a String object.
     *
     * @param array the byte array value to convert.
     * @return the converted String. 
     * @see #toString(char[]) 
     */    
    public static String toString(char[] array)
    {
        int count = 0;
        for(int i = 0; i < array.length; i++)
        {
            if (array[i] == 0)
            {
                count = i;
                break;
            }
        }
        return new String(array,0,count);
    }     

}
