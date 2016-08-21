/*
 * NativeBufferIteratorImpl.java
 *
 * Created on 9 de enero de 2004, 14:03
 */

package com.innowhere.jnieasy.core.impl.mem;

/**
 *
 * @author  jmarranz
 */

/* Los incrementos son los correspondientes al tamaño en Java y los correspondientes 
 * JNI Win32 de los tipos de datos primitivos considerados para plataforma de 32 bits
 */

import com.innowhere.jnieasy.core.mem.*;

public class NativeBufferIteratorImpl implements NativeBufferIterator
{
    private long bytePos;
    private NativeBufferImpl buffer;
            
    /** Creates a new instance of NativeBufferIteratorImpl */
    public NativeBufferIteratorImpl(NativeBufferImpl buffer)
    {
        this.buffer = buffer;
    }
    
    public NativeBuffer getBuffer()
    {
        return buffer;
    }
    
    public NativeBufferImpl getBufferInternal()
    {
        return buffer;
    }    
    
    public long currentOffset()
    {
        return bytePos;
    }

    public long currentAddress()
    {
        return buffer.getValue() + bytePos;
    }
    
    public long forward(long bytes)
    {        
        /* No hacemos chequeos porque es en el propio NativeBufferImpl al acceder
         * donde se hace el chequeo.
         */
        bytePos += bytes;
        return bytePos;
    }

    public long backward(long bytes)
    {
        /* Ver forward() */
        bytePos -= bytes;
        return bytePos;
    }    
    
    public boolean nextBoolean()
    {
        boolean value = buffer.getBoolean(bytePos);
        bytePos += TypeSizes.getBooleanSize();
        return value;
    }

    public void setBoolean(boolean value)
    {
        buffer.setBoolean(bytePos,value);
        bytePos += TypeSizes.getBooleanSize();        
    }
    
    public boolean[] nextBooleanArray(boolean[] buff, int index, int length)
    {
        boolean[] value = buffer.getBooleanArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getBooleanSize();
        return value;
    }    
    
    public void setBooleanArray(boolean[] value,int index,int length)
    {
        buffer.setBooleanArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getBooleanSize();        
    }

    public byte nextByte()
    {
        byte value = buffer.getByte(bytePos);
        bytePos += TypeSizes.getByteSize();
        return value;
    }

    public void setByte(byte value)
    {
        buffer.setByte(bytePos,value);
        bytePos += TypeSizes.getByteSize();        
    }
    
    public byte[] nextByteArray(byte[] buff, int index, int length)
    {
        byte[] value = buffer.getByteArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getByteSize();
        return value;
    }    
    
    public void setByteArray(byte[] value,int index,int length)
    {
        buffer.setByteArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getByteSize();        
    }

    public char nextChar()
    {
        char value = buffer.getChar(bytePos);
        bytePos += TypeSizes.getCharSize();
        return value;
    }

    public void setChar(char value)
    {
        buffer.setChar(bytePos,value);
        bytePos += TypeSizes.getCharSize();        
    }
    
    public char[] nextCharArray(char[] buff, int index, int length)
    {
        char[] value = buffer.getCharArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getCharSize();
        return value;
    }    
    
    public void setCharArray(char[] value,int index,int length)
    {
        buffer.setCharArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getCharSize();        
    }
    
    public short nextShort()
    {
        short value = buffer.getShort(bytePos);
        bytePos += TypeSizes.getShortSize();
        return value;
    }

    public void setShort(short value)
    {
        buffer.setShort(bytePos,value);
        bytePos += TypeSizes.getShortSize();        
    }
    
    public short[] nextShortArray(short[] buff, int index, int length)
    {
        short[] value = buffer.getShortArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getShortSize();
        return value;
    }    
    
    public void setShortArray(short[] value,int index,int length)
    {
        buffer.setShortArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getShortSize();        
    }
    
    public int nextInt()
    {
        int value = buffer.getInt(bytePos);
        bytePos += TypeSizes.getIntSize();
        return value;
    }

    public void setInt(int value)
    {
        buffer.setInt(bytePos,value);
        bytePos += TypeSizes.getIntSize();        
    }
    
    public int[] nextIntArray(int[] buff, int index, int length)
    {
        int[] value = buffer.getIntArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getIntSize();
        return value;
    }    
    
    public void setIntArray(int[] value,int index,int length)
    {
        buffer.setIntArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getIntSize();        
    }
    
    public long nextLong()
    {
        long value = buffer.getLong(bytePos);
        bytePos += TypeSizes.getLongSize();
        return value;
    }

    public void setLong(long value)
    {
        buffer.setLong(bytePos,value);
        bytePos += TypeSizes.getLongSize();        
    }
    
    public long[] nextLongArray(long[] buff, int index, int length)
    {
        long[] value = buffer.getLongArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getLongSize();
        return value;
    }    
    
    public void setLongArray(long[] value,int index,int length)
    {
        buffer.setLongArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getLongSize();        
    }
    
    public float nextFloat()
    {
        float value = buffer.getFloat(bytePos);
        bytePos += TypeSizes.getFloatSize();
        return value;
    }

    public void setFloat(float value)
    {
        buffer.setFloat(bytePos,value);
        bytePos += TypeSizes.getFloatSize();        
    }
    
    public float[] nextFloatArray(float[] buff, int index, int length)
    {
        float[] value = buffer.getFloatArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getFloatSize();
        return value;
    }    
    
    public void setFloatArray(float[] value,int index,int length)
    {
        buffer.setFloatArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getFloatSize();        
    }
    
    public double nextDouble()
    {
        double value = buffer.getDouble(bytePos);
        bytePos += TypeSizes.getDoubleSize();
        return value;
    }

    public void setDouble(double value)
    {
        buffer.setDouble(bytePos,value);
        bytePos += TypeSizes.getDoubleSize();        
    }
    
    public double[] nextDoubleArray(double[] buff, int index, int length)
    {
        double[] value = buffer.getDoubleArray(bytePos,buff,index,length);
        bytePos += length * TypeSizes.getDoubleSize();
        return value;
    }    
    
    public void setDoubleArray(double[] value,int index,int length)
    {
        buffer.setDoubleArray(bytePos,value,index,length);
        bytePos += length * TypeSizes.getDoubleSize();        
    }
    
    public long nextAddress()
    {
        long value = buffer.getAddress(bytePos);
        bytePos += TypeSizes.getADDRESS();
        return value;
    }

    public void setAddress(long value)
    {
        buffer.setAddress(bytePos,value);
        bytePos += TypeSizes.getADDRESS();        
    }
    

    public String getAnsiString()
    {
        String value = buffer.getAnsiString(bytePos);
        // Ahora calculamos cuanto nos hemos movido
        long delta = TypeSizes.getByteSize() * (value.length() + 1); // El +1 es el nulo final
        forward(delta);   
        return value;        
    }    

    public void setAnsiString(String value)
    {
        buffer.setAnsiString(bytePos,value);
        // Ahora calculamos cuanto nos hemos movido
        long delta = TypeSizes.getByteSize() * (value.length() + 1); // El +1 es el nulo final
        forward(delta);
    }    
    
    public String getUnicodeString()
    {
        String value = buffer.getUnicodeString(bytePos);
        // Ahora calculamos cuanto nos hemos movido
        long delta = TypeSizes.getWCharTSize() * (value.length() + 1); // El +1 es el nulo final
        forward(delta);   
        return value;
    }    
    
    public void setUnicodeString(String value)
    {
        buffer.setUnicodeString(bytePos,value);
        // Ahora calculamos cuanto nos hemos movido
        long delta = TypeSizes.getWCharTSize() * (value.length() + 1); // El +1 es el nulo final
        forward(delta);
    }        
    
    public StringBuffer getAnsiStringBuffer() 
    {
        String str = getAnsiString();
        return NativeBufferImpl.copyToStringBuffer(str,new StringBuffer());
    }            
    
    public void setAnsiStringBuffer(StringBuffer value)
    {
        String str = value.toString();
        setAnsiString(str);
    }    
    
    public StringBuffer getUnicodeStringBuffer() 
    {
        String str = getUnicodeString();
        return NativeBufferImpl.copyToStringBuffer(str,new StringBuffer());  
    }    
    
    public void setUnicodeStringBuffer(StringBuffer value)
    {
        String str = value.toString();
        setUnicodeString(str);
    }            
    
    public NativeBuffer nextBuffer(long size)
    {
        NativeBuffer res = buffer.getBuffer(bytePos,size);
        bytePos += size;       
        return res;
    }
    
    public void setBuffer(NativeBuffer value) 
    {
        long size = value.size();
        buffer.setBuffer(bytePos,value);
        bytePos += size;        
    }     
    
}
