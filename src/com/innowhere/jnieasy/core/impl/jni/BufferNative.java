
package com.innowhere.jnieasy.core.impl.jni; 

public class BufferNative 
{

    public BufferNative() 
    {
        long i = 0;
    }
    
    public static native long malloc(long size,boolean executable);
    public static native void free(long address,boolean executable);
    public static native long realloc(long address,long size);    
    
    public static native byte getByte(long address,long offset);
   
    public static native boolean getBoolean(long address,long offset);
    
    public static native char getChar(long address,long offset);

    public static native short getShort(long address,long offset);
    
    public static native int getInt(long address,long offset);
 
    public static native long getLong(long address,long offset);
    
    public static native float getFloat(long address,long offset);
    
    public static native double getDouble(long address,long offset);     

    public static native int getStringLength(long address,long offset);    

    public static native int getStringUnicodeLength(long address,long offset);

    public static native void getBooleanArray(long address,long offset, boolean[] buf, int index, int length);
    
    public static native void getByteArray(long address,long offset, byte[] buf, int index, int length);

    public static native void getCharArray(long address,long offset, char[] buf, int index, int length);

    public static native void getShortArray(long address,long offset, short[] buf, int index, int length);
    
    public static native void getIntArray(long address,long offset, int[] buf, int index, int length);
    
    public static native void getLongArray(long address,long offset, long[] buf, int index, int length);

    public static native void getFloatArray(long address,long offset, float[] buf, int index, int length);
  
    public static native void getDoubleArray(long address,long offset, double[] buf, int index, int length);

    public static native void setByte(long address,long offset, byte value);

    public static native void setBoolean(long address,long offset, boolean value);

    public static native void setChar(long address,long offset, char value);
    
    public static native void setShort(long address,long offset, short value);
    
    public static native void setInt(long address,long offset, int value);
    
    public static native void setLong(long address,long offset, long value);
    
    public static native void setFloat(long address,long offset, float value);
    
    public static native void setDouble(long address,long offset, double value);

    public static native void setBooleanArray(long address,long offset, boolean[] buf, int index, int length);

    public static native void setByteArray(long address,long offset, byte[] buf, int index, int length);

    public static native void setCharArray(long address,long offset, char[] buf, int index, int length);
  
    public static native void setShortArray(long address,long offset, short[] buf, int index, int length);
       
    public static native void setIntArray(long address,long offset, int[] buf, int index, int length);
    
    public static native void setLongArray(long address,long offset, long[] buf, int index, int length);
    
    public static native void setFloatArray(long address,long offset, float[] buf, int index, int length);
    
    public static native void setDoubleArray(long address,long offset, double[] buf, int index, int length);

    public static native void copyFrom(long address,long offset, long sourceAddr,long length);
}



